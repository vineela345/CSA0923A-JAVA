import java.util.*;
import java.util.concurrent.*;

class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        List<Future<Integer>> tasks = new ArrayList<>();

        // Each task processes one student's score
        int[] scores = {80, 90, 75, 110, 65};

        for (int score : scores) {
            tasks.add(pool.submit(() -> {
                if (score < 0 || score > 100)
                    throw new Exception("Invalid score: " + score);
                return score;
            }));
        }

        int success = 0;
        int failed = 0;

        for (Future<Integer> task : tasks) {
            try {
                System.out.println("Processed score: " + task.get());
                success++;
            } catch (ExecutionException e) {
                System.out.println("Failed: " + e.getCause().getMessage());
                failed++;
            }
        }

        pool.shutdown();

        System.out.println("Successful files: " + success);
        System.out.println("Failed files: " + failed);
        System.out.println("Total processed: " + (success + failed));
    }
}
