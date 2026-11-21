import java.util.concurrent.*;

class Main {
    public static void main(String[] args) throws InterruptedException {
        // Queue can store only 5 tokens
        BlockingQueue<Integer> counter = new ArrayBlockingQueue<>(5);
        int[] total = {0};

        Thread cook = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    counter.put(i);
                    System.out.println("Cook made token " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread student = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    int token = counter.take();
                    total[0] += token;
                    System.out.println("Student collected " + token);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        cook.start();
        student.start();

        cook.join();
        student.join();

        System.out.println("Total token value: " + total[0]);
    }
}
