package uz.logging;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class TelegramAlarmHandler extends StreamHandler {
    public TelegramAlarmHandler(){
        super.setFilter(new TelegramAlarmFilter());
    }

    @Override
    public synchronized void publish(LogRecord record) {
        if (isLoggable(record)) {
            HttpClient client = HttpClient.newHttpClient();

            String message = """
                    {
                        "chat_id": "%s",
                        "text": "%s"
                    }
                    """.formatted(Secrets.CHAT_ID, record.getMessage());
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(message))
                    .uri(URI.create(Secrets.SEND_MESSAGE))
                    .header("Content-Type", "application/json")
                    .build();
            try {
                HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("---> " + send);
            } catch (IOException | InterruptedException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return getFilter().isLoggable(record);
    }
}
