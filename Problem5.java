import java.util.Arrays;
import java.util.Scanner;

public class Problem5 {


    public static void partitionRecursive(int[] a, int k, int left, int right) {

        if (left >= right) {
            return;
        }

        if (a[left] <= k) {

            partitionRecursive(a, k, left + 1, right);
        } else if (a[right] > k) {

            partitionRecursive(a, k, left, right - 1);
        } else {

            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            partitionRecursive(a, k, left + 1, right - 1);
        }
    }


    public static void partitionIterative(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {

            while (left < right && a[left] <= k) {
                left++;
            }

            while (left < right && a[right] > k) {
                right--;
            }

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
    }


    public static void partitionBySorting(int[] a, int k) {
        Arrays.sort(a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("กรอกตัวเลขในอาร์เรย์ (เช่น 12, 4, 7, 15, 3, 10, 8 หรือ [12, 4, 7, 15, 3, 10, 8]):");
        String inputLine = scanner.nextLine().trim();

        System.out.print("กรอกค่า k (เช่น 8): ");
        int k = scanner.nextInt();

        if (inputLine.isEmpty()) {
            System.out.println("ไม่ได้กรอกข้อมูล!");
            scanner.close();
            return;
        }


        String cleanInput = inputLine.replaceAll("[\\[\\]]", "").trim();
        String[] parts = cleanInput.split("[,\\s]+");

        int[] original = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            original[i] = Integer.parseInt(parts[i].trim());
        }

        System.out.println("\n=== ข้อมูลเริ่มต้น ===");
        System.out.println("Array : " + Arrays.toString(original));
        System.out.println("k     : " + k);


        int[] arr1 = original.clone();
        partitionRecursive(arr1, k, 0, arr1.length - 1);
        System.out.println("\n1. Recursive Partition : " + Arrays.toString(arr1));


        int[] arr2 = original.clone();
        partitionIterative(arr2, k);
        System.out.println("2. Iterative Partition : " + Arrays.toString(arr2));


        int[] arr3 = original.clone();
        partitionBySorting(arr3, k);
        System.out.println("3. Sorting-Based       : " + Arrays.toString(arr3));

        scanner.close();
    }
}