import java.util.Stack;

public class StackCaseStudy {
    public static void main(String[] args) {
        Stack<String> undoStack = new Stack<>();

        // 1. เพิ่มคำสั่งทั้งหมดลงใน Stack
        undoStack.push("Type Data"); //[cite: 1]
        undoStack.push("Type Structure"); //[cite: 1]
        undoStack.push("Delete Structure"); //[cite: 1]
        undoStack.push("Type Algorithm"); //[cite: 1]
        undoStack.push("Type Java"); //[cite: 1]

        System.out.println("--- กรณีศึกษาที่ 2: ระบบ Undo ในโปรแกรมจดบันทึก ---");
        // 2. แสดงคำสั่งทั้งหมดใน Stack
        System.out.println("คำสั่งทั้งหมดใน Stack: " + undoStack); //[cite: 1]

        // 3 & 6. Undo คำสั่งล่าสุด 2 ครั้ง พร้อมตรวจสอบก่อน pop() ว่า Stack ว่างหรือไม่
        System.out.println("\nกำลังเรียกใช้ Undo 2 ครั้ง...");
        for (int i = 1; i <= 2; i++) { //[cite: 1]
            if (!undoStack.isEmpty()) { //[cite: 1]
                String undoneCommand = undoStack.pop();
                // 4. แสดงคำสั่งที่ถูก Undo
                System.out.println("คำสั่งที่ถูก Undo: " + undoneCommand); //[cite: 1]
            } else {
                System.out.println("Stack ว่างเปล่า ไม่สามารถ Undo ได้");
            }
        }

        // 5. แสดงสถานะของ Stack หลังจาก Undo
        System.out.println("\nสถานะของ Stack หลังจาก Undo: " + undoStack); //[cite: 1]

        // 7. อธิบายว่า Stack ใช้หลักการ LIFO อย่างไร
        System.out.println("\nคำอธิบายหลักการ LIFO ของ Stack:"); //[cite: 1]
        System.out.println("Stack ทำงานตามหลักการ LIFO (เข้าหลังสุด ออกก่อนสุด) " +
                "คำสั่งล่าสุดที่ถูกเพิ่มเข้าไป (Type Java) จะอยู่บนสุดของ Stack " +
                "และจะเป็นคำสั่งแรกที่ถูกยกเลิก (นำออก) เมื่อมีการเรียกใช้คำสั่ง Undo เสมอ"); //[cite: 1]
    }
}