package uz.forkjoin;

import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private double[] numbers;
    private int from;
    private int to;
    private int limit = 1000;

    public CustomRecursiveTask(double[] numbers, int from, int to) {
        this.numbers = numbers;
        this.from = from;
        this.to = to;
    }


    @Override
    protected Integer compute() {
        if(to - from < limit){
            int count = 0;
            for (int i = from; i < to; i++) {
                if (numbers[i]>0.4) count++;
            }
            return count;
        }
        else{
            int mid = from + (to - from) / 2;
            CustomRecursiveTask firstHalf = new CustomRecursiveTask(numbers, from, mid);
            CustomRecursiveTask secondHalf = new CustomRecursiveTask(numbers, mid, to);
            invokeAll(firstHalf, secondHalf);
            return firstHalf.join()+secondHalf.join();
        }
    }
}
