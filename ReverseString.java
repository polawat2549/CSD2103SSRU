import java.util.Random;

/**
 * ข้อ 1: การกลับลำดับสตริง (String Reversal)
 * ----------------------------------------------------
 * มี 2 อัลกอริทึมหลักตามที่โจทย์กำหนด และ 1 อัลกอริทึมเสริม (bonus)
 * ที่แสดงให้เห็นว่า recursive ก็ทำให้เร็วเท่า iterative ได้
 * ถ้าหลีกเลี่ยงปัญหาการต่อสตริงด้วย + และ substring()
 */
public class ReverseString {

    /**
     * อัลกอริทึมที่ 1: Recursive Algorithm
     * แนวคิด: นำตัวอักษรตัวแรกไปต่อท้ายผลลัพธ์ของการกลับสตริงส่วนที่เหลือ
     * Base case      : สตริงว่างหรือมีความยาว <= 1 ตัวอักษร -> คืนค่าตัวเอง
     * Recursive case : reverse(s) = reverse(s ตัดตัวแรกออก) + ตัวอักษรตัวแรก
     *
     * หมายเหตุสำคัญ: เมธอดนี้จงใจใช้ substring() และ + (string concatenation)
     * เพื่อให้เห็นผลกระทบของความเป็น immutable ของ String ต่อ Time Complexity
     * (ดูการวิเคราะห์ท้ายไฟล์ / ในรายงาน)
     */
    static String reverseRecursive(String s) {
        if (s.length() <= 1) {
            return s; // base case
        }
        char firstChar = s.charAt(0);
        String rest = s.substring(1);              // substring คัดลอกข้อมูล O(n)
        return reverseRecursive(rest) + firstChar;  // concatenation สร้าง String ใหม่ O(n)
    }

    /**
     * อัลกอริทึมที่ 2: Iterative Algorithm
     * แนวคิด: ใช้ StringBuilder (โครงสร้างข้อมูลที่ mutable) วนอ่านตัวอักษร
     * จากตำแหน่งสุดท้ายไล่กลับไปตำแหน่งแรก แล้ว append ทีละตัว
     * -> หลีกเลี่ยงการสร้าง String ใหม่ซ้ำ ๆ เหมือนวิธี recursive
     */
    static String reverseIterative(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * (Bonus) Recursive แบบปรับปรุง: ใช้ char array + two-pointer แทนการต่อสตริง
     * เพื่อพิสูจน์ว่าปัญหาไม่ได้อยู่ที่ "การเวียนเกิด" แต่อยู่ที่ "การต่อ String ด้วย +"
     * Base case      : left >= right (ตัวชี้สองด้านชนกันหรือข้ามกันแล้ว)
     * Recursive case : สลับตัวอักษรที่ left กับ right แล้วเรียกตัวเองกับช่วงที่แคบลง
     */
    static String reverseRecursiveOptimized(String s) {
        char[] chars = s.toCharArray();
        reverseHelper(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private static void reverseHelper(char[] chars, int left, int right) {
        if (left >= right) {
            return; // base case
        }
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        reverseHelper(chars, left + 1, right - 1); // recursive case
    }

    // ---------- ทดสอบผลลัพธ์ตามตัวอย่างในโจทย์ ----------
    public static void main(String[] args) {
        String input = "pots&pans";
        System.out.println("=== ทดสอบผลลัพธ์ตามตัวอย่างในโจทย์ ===");
        System.out.println("Input                     : " + input);
        System.out.println("reverseRecursive           : " + reverseRecursive(input));
        System.out.println("reverseIterative           : " + reverseIterative(input));
        System.out.println("reverseRecursiveOptimized  : " + reverseRecursiveOptimized(input));

        System.out.println();
        System.out.println("=== ทดสอบวัดเวลาจริงตามขนาดที่โจทย์กำหนด (10, 100, 1000, 10000) ===");
        int[] sizes = {10, 100, 1000, 10000};
        Random rand = new Random(42);
        System.out.printf("%-10s %-22s %-22s %-22s%n", "n", "Recursive (ns)", "Iterative (ns)", "Recursive-Opt (ns)");
        for (int n : sizes) {
            String s = randomString(n, rand);
            String t1 = timeItSafe(() -> reverseRecursive(s));
            String t2 = timeItSafe(() -> reverseIterative(s));
            String t3 = timeItSafe(() -> reverseRecursiveOptimized(s));
            System.out.printf("%-10d %-22s %-22s %-22s%n", n, t1, t2, t3);
        }
    }

    private static String randomString(int n, Random rand) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append((char) ('a' + rand.nextInt(26)));
        }
        return sb.toString();
    }

    private interface Task { String run(); }

    private static long timeIt(Task task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start;
    }

    // ใช้ดักจับ StackOverflowError จากเมธอด recursive ที่ลึกเกินไป
    // (แสดงข้อจำกัดด้านหน่วยความจำของ recursion ให้เห็นจริงตามที่โจทย์ให้วิเคราะห์)
    private static String timeItSafe(Task task) {
        try {
            long start = System.nanoTime();
            task.run();
            long end = System.nanoTime();
            return String.valueOf(end - start);
        } catch (StackOverflowError e) {
            return "StackOverflowError";
        }
    }
}