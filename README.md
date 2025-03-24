# Input/Output Streams
***
## Byte Streams
```java
public class ByteStreamExample {
    public static void main(String[] args) {
        try {
            // Faylga yozish
            FileOutputStream fos = new FileOutputStream("output.txt");
            String text = "Salom, Java!";
            fos.write(text.getBytes());
            fos.close();

            // Fayldan o'qish
            FileInputStream fis = new FileInputStream("output.txt");
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```