import java.util.Arrays;
import java.util.Scanner;

public class Problem6 {

    public static boolean findPairBruteForce(int[] a, int k) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == k) {
                    System.out.println("Pair found (Brute Force): " + a[i] + " and " + a[j]);
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean findPairRecursive(int[] a, int k, int left, int right) {

        if (left >= right) {
            return false;
        }

        int sum = a[left] + a[right];

        if (sum == k) {
            System.out.println("Pair found (Recursive Two-Pointer): " + a[left] + " and " + a[right]);
            return true;
        } else if (sum < k) {

            return findPairRecursive(a, k, left + 1, right);
        } else {
            return findPairRecursive(a, k, left, right - 1);
        }
    }


    public static boolean findPairBinarySearch(int[] a, int k) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int target = k - a[i];
            // ค้นหา target ในช่วงดัชนี (i + 1) ถึง (n - 1)
            int foundIndex = binarySearch(a, i + 1, n - 1, target);
            if (foundIndex != -1) {
                System.out.println("Pair found (Binary Search): " + a[i] + " and " + a[foundIndex]);
                return true;
            }
        }
        return false;
    }


    private static int binarySearch(int[] a, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("กรอกอาร์เรย์ที่เรียงจากน้อยไปมากแล้ว (เช่น 2, 4, 7, 11, 15, 20):");
        String inputLine = scanner.nextLine().trim();

        System.out.print("กรอกค่า k ที่ต้องการหาผลรวม (เช่น 18): ");
        int k = scanner.nextInt();

        if (inputLine.isEmpty()) {
            System.out.println("ไม่ได้กรอกข้อมูล!");
            scanner.close();
            return;
        }


        String cleanInput = inputLine.replaceAll("[\\[\\]]", "").trim();
        String[] parts = cleanInput.split("[,\\s]+");

        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            a[i] = Integer.parseInt(parts[i].trim());
        }

        System.out.println("\n=== ข้อมูลที่รับเข้ามา ===");
        System.out.println("Array A : " + Arrays.toString(a));
        System.out.println("Target k: " + k);
        System.out.println("----------------------------------");


        boolean found1 = findPairBruteForce(a, k);


        boolean found2 = findPairRecursive(a, k, 0, a.length - 1);


        boolean found3 = findPairBinarySearch(a, k);

        if (!found1 && !found2 && !found3) {
            System.out.println("No pair found with sum = " + k);
        }

        scanner.close();
    }
}