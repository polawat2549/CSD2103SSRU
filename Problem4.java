import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {

    /**
     * อัลกอริทึมที่ 1: Recursive Two-Pointer
     * สลับตำแหน่งคู่-คี่ แบบเวียนเกิด
     */
    public static void rearrangeRecursive(int[] a, int left, int right) {
        // Base Case: เมื่อตัวชี้วิ่งมาชนหรือสวนทางกัน
        if (left >= right) {
            return;
        }

        if (a[left] % 2 == 0) {
            // ด้านซ้ายเป็นคู่แล้ว เลื่อน left ไปทางขวา
            rearrangeRecursive(a, left + 1, right);
        } else if (a[right] % 2 != 0) {
            // ด้านขวาเป็นคี่แล้ว เลื่อน right ไปทางซ้าย
            rearrangeRecursive(a, left, right - 1);
        } else {
            // ด้านซ้ายเป็นคี่ และด้านขวาเป็นคู่ ให้สลับค่า แล้วเลื่อนตัวชี้ทั้งสอง
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            rearrangeRecursive(a, left + 1, right - 1);
        }
    }

    /**
     * อัลกอริทึมที่ 2: Iterative Two-Pointer
     * สลับตำแหน่งคู่-คี่ แบบใช้ลูป
     */
    public static void rearrangeTwoPointer(int[] a) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            // เลื่อน left ไปทางขวาจนกว่าจะเจอเลขคี่
            while (left < right && a[left] % 2 == 0) {
                left++;
            }
            // เลื่อน right ไปทางซ้ายจนกว่าจะเจอเลขคู่
            while (left < right && a[right] % 2 != 0) {
                right--;
            }
            // สลับค่าระหว่างคี่ (ซ้าย) กับคู่ (ขวา)
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
    }

    /**
     * อัลกอริทึมที่ 3: Extra Array
     * สร้างอาร์เรย์ใหม่ ใส่เลขคู่ก่อน แล้วตามด้วยเลขคี่
     */
    public static int[] rearrangeExtraArray(int[] a) {
        int[] result = new int[a.length];
        int index = 0;

        // วนรอบที่ 1: ใส่จำนวนคู่ทั้งหมดลงในอาร์เรย์ใหม่
        for (int val : a) {
            if (val % 2 == 0) {
                result[index++] = val;
            }
        }

        // วนรอบที่ 2: ใส่จำนวนคี่ทั้งหมดลงในอาร์เรย์ใหม่
        for (int val : a) {
            if (val % 2 != 0) {
                result[index++] = val;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("กรอกตัวเลขจำนวนเต็ม (รองรับทั้งช่องว่าง จุลภาค หรือ [5, 2, 7]):");
        String inputLine = scanner.nextLine().trim();

        if (inputLine.isEmpty()) {
            System.out.println("ไม่ได้กรอกข้อมูล!");
            scanner.close();
            return;
        }

        // ตัดวงเล็บ [ ] ออก และตัดคำด้วยเครื่องหมายจุลภาค (,) หรือ ช่องว่าง
        String cleanInput = inputLine.replaceAll("[\\[\\]]", "").trim();
        String[] parts = cleanInput.split("[,\\s]+");

        int[] original = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            original[i] = Integer.parseInt(parts[i].trim());
        }

        System.out.println("\n=== อาร์เรย์เริ่มต้น ===");
        System.out.println(Arrays.toString(original));

        // ทดสอบ Algorithm 1: Recursive Two-Pointer
        int[] arr1 = original.clone();
        rearrangeRecursive(arr1, 0, arr1.length - 1);
        System.out.println("\n1. Recursive Two-Pointer : " + Arrays.toString(arr1));

        // ทดสอบ Algorithm 2: Iterative Two-Pointer
        int[] arr2 = original.clone();
        rearrangeTwoPointer(arr2);
        System.out.println("2. Iterative Two-Pointer : " + Arrays.toString(arr2));

        // ทดสอบ Algorithm 3: Extra Array (Stable Algorithm)
        int[] arr3 = rearrangeExtraArray(original);
        System.out.println("3. Extra Array (Stable)  : " + Arrays.toString(arr3));

        scanner.close();
    }
}