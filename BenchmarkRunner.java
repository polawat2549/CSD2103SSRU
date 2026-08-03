import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {

    // ==========================================
    // อัลกอริทึม ข้อ 4: การจัดกลุ่มคู่-คี่
    // ==========================================
    public static void rearrangeRecursive(int[] a, int left, int right) {
        if (left >= right) return;
        if (a[left] % 2 == 0) {
            rearrangeRecursive(a, left + 1, right);
        } else if (a[right] % 2 != 0) {
            rearrangeRecursive(a, left, right - 1);
        } else {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            rearrangeRecursive(a, left + 1, right - 1);
        }
    }

    public static void rearrangeTwoPointer(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            while (left < right && a[left] % 2 == 0) left++;
            while (left < right && a[right] % 2 != 0) right--;
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static int[] rearrangeExtraArray(int[] a) {
        int[] result = new int[a.length];
        int idx = 0;
        for (int v : a) if (v % 2 == 0) result[idx++] = v;
        for (int v : a) if (v % 2 != 0) result[idx++] = v;
        return result;
    }

    // ==========================================
    // อัลกอริทึม ข้อ 6: ค้นหาคู่ผลรวม k
    // ==========================================
    public static boolean findPairBruteForce(int[] a, int k) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == k) return true;
            }
        }
        return false;
    }

    public static boolean findPairRecursive(int[] a, int k, int left, int right) {
        if (left >= right) return false;
        int sum = a[left] + a[right];
        if (sum == k) return true;
        else if (sum < k) return findPairRecursive(a, k, left + 1, right);
        else return findPairRecursive(a, k, left, right - 1);
    }

    public static boolean findPairBinarySearch(int[] a, int k) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int target = k - a[i];
            if (Arrays.binarySearch(a, i + 1, n, target) >= 0) return true;
        }
        return false;
    }

    // ==========================================
    // MAIN METHOD: รัน Benchmark และพิมพ์ผลลัพธ์
    // ==========================================
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        Random rand = new Random(42);

        System.out.println("=========================================================================");
        System.out.println("   ผลการทดลองข้อ 4: การจัดกลุ่มคู่-คี่ (Average 5 runs in nanoseconds)");
        System.out.println("=========================================================================");
        System.out.printf("%-12s | %-20s | %-20s | %-20s\n", "Size (n)", "1. Recursive (ns)", "2. Iterative (ns)", "3. Extra Array (ns)");
        System.out.println("-------------------------------------------------------------------------");

        for (int n : sizes) {
            int[] testData = new int[n];
            for (int i = 0; i < n; i++) testData[i] = rand.nextInt(100000);

            // 1. Recursive Two-Pointer
            String recTime;
            try {
                long sum = 0;
                for (int r = 0; r < 5; r++) {
                    int[] copy = testData.clone();
                    long start = System.nanoTime();
                    rearrangeRecursive(copy, 0, copy.length - 1);
                    long end = System.nanoTime();
                    sum += (end - start);
                }
                recTime = String.valueOf(sum / 5);
            } catch (StackOverflowError e) {
                recTime = "StackOverflowError";
            }

            // 2. Iterative Two-Pointer
            long sumIter = 0;
            for (int r = 0; r < 5; r++) {
                int[] copy = testData.clone();
                long start = System.nanoTime();
                rearrangeTwoPointer(copy);
                long end = System.nanoTime();
                sumIter += (end - start);
            }

            // 3. Extra Array
            long sumExtra = 0;
            for (int r = 0; r < 5; r++) {
                int[] copy = testData.clone();
                long start = System.nanoTime();
                rearrangeExtraArray(copy);
                long end = System.nanoTime();
                sumExtra += (end - start);
            }

            System.out.printf("%-12d | %-20s | %-20d | %-20d\n", n, recTime, sumIter / 5, sumExtra / 5);
        }

        System.out.println("\n=========================================================================");
        System.out.println("   ผลการทดลองข้อ 6: ค้นหาคู่ผลรวม k (Average 5 runs in nanoseconds)");
        System.out.println("=========================================================================");
        System.out.printf("%-12s | %-20s | %-20s | %-20s\n", "Size (n)", "1. Brute Force (ns)", "2. Recursive (ns)", "3. Binary Search (ns)");
        System.out.println("-------------------------------------------------------------------------");

        for (int n : sizes) {
            int[] sortedData = new int[n];
            for (int i = 0; i < n; i++) sortedData[i] = i * 2; // [0, 2, 4, 6, ...]
            int targetK = n * 4 + 10; // ค่า k ที่ไม่มีทางหาเจอ เพื่อทดสอบ Worst-Case

            // 1. Brute Force
            String bfTime;
            if (n > 10000) {
                bfTime = "Timeout (> 10 sec)";
            } else {
                long sum = 0;
                for (int r = 0; r < 5; r++) {
                    long start = System.nanoTime();
                    findPairBruteForce(sortedData, targetK);
                    long end = System.nanoTime();
                    sum += (end - start);
                }
                bfTime = String.valueOf(sum / 5);
            }

            // 2. Recursive Two-Pointer
            String recTime;
            try {
                long sum = 0;
                for (int r = 0; r < 5; r++) {
                    long start = System.nanoTime();
                    findPairRecursive(sortedData, targetK, 0, sortedData.length - 1);
                    long end = System.nanoTime();
                    sum += (end - start);
                }
                recTime = String.valueOf(sum / 5);
            } catch (StackOverflowError e) {
                recTime = "StackOverflowError";
            }

            // 3. Binary Search
            long sumBS = 0;
            for (int r = 0; r < 5; r++) {
                long start = System.nanoTime();
                findPairBinarySearch(sortedData, targetK);
                long end = System.nanoTime();
                sumBS += (end - start);
            }

            System.out.printf("%-12d | %-20s | %-20s | %-20d\n", n, bfTime, recTime, sumBS / 5);
        }
    }
}