import java.util.Arrays;

public class Problem1 {


    public static String reverseRecursive(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        return s.charAt(s.length() - 1) + reverseRecursive(s.substring(0, s.length() - 1));
    }


    public static String reverseIterative(String s) {
        if (s == null) return null;

        StringBuilder sb = new StringBuilder(s.length());

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "pots&pans";
        System.out.println("=== Test Example ===");
        System.out.println("Input:     " + input);
        System.out.println("Recursive: " + reverseRecursive(input));
        System.out.println("Iterative: " + reverseIterative(input));


        int[] sizes = {10, 100, 1000, 10000};
        System.out.println("\n=== Performance Benchmark (Average 5 runs in nanoseconds) ===");
        System.out.printf("%-10s | %-20s | %-20s\n", "Size (N)", "Iterative (ns)", "Recursive (ns)");
        System.out.println("---------------------------------------------------------");

        for (int n : sizes) {
            String testStr = "a".repeat(n);


            long sumIterative = 0;
            for (int i = 0; i < 5; i++) {
                long start = System.nanoTime();
                reverseIterative(testStr);
                long end = System.nanoTime();
                sumIterative += (end - start);
            }
            long avgIterative = sumIterative / 5;


            long avgRecursive = 0;
            try {
                long sumRecursive = 0;
                for (int i = 0; i < 5; i++) {
                    long start = System.nanoTime();
                    reverseRecursive(testStr);
                    long end = System.nanoTime();
                    sumRecursive += (end - start);
                }
                avgRecursive = sumRecursive / 5;
            } catch (StackOverflowError e) {
                avgRecursive = -1;
            }

            String recResult = (avgRecursive == -1) ? "StackOverflowError" : String.valueOf(avgRecursive);
            System.out.printf("%-10d | %-20d | %-20s\n", n, avgIterative, recResult);
        }
    }
}