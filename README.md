# งานทบทวนก่อนเรียน
## กรณีศึกษาที่ 1: Array  

```java
public class ArrayCaseStudy {
    public static void main(String[] args) {
        // บันทึกคะแนนไว้ใน Array ตามโจทย์
        int[] scores = {6, 8, 4, 9, 7, 5, 10, 3, 8, 2};

        int totalScore = 0;
        int maxScore = scores[0];
        int minScore = scores[0];
        int countPass = 0;

        // วนลูปคำนวณข้อมูล
        for (int i = 0; i < scores.length; i++) {
            totalScore += scores[i];
            if (scores[i] > maxScore) maxScore = scores[i];
            if (scores[i] < minScore) minScore = scores[i];
            if (scores[i] >= 7) countPass++;
        }

        double averageScore = (double) totalScore / scores.length;

        System.out.println("--- กรณีศึกษาที่ 1: ระบบวิเคราะห์คะแนนสอบก่อนเรียน ---");
        System.out.println("--- สิ่งที่ต้องทำ ---");

        // 1. คะแนนรวมของนักศึกษาทั้งหมด
        System.out.println("1. คะแนนรวมของนักศึกษาทั้งหมด: " + totalScore + " คะแนน");
        // 2. คะแนนเฉลี่ย
        System.out.println("2. คะแนนเฉลี่ย: " + averageScore + " คะแนน");
        // 3. คะแนนสูงสุด
        System.out.println("3. คะแนนสูงสุด: " + maxScore + " คะแนน");
        // 4. คะแนนต่ำสุด
        System.out.println("4. คะแนนต่ำสุด: " + minScore + " คะแนน");
        // 5. จำนวนนักศึกษาที่ได้คะแนนตั้งแต่ 7 คะแนนขึ้นไป
        System.out.println("5. จำนวนนักศึกษาที่ได้คะแนนตั้งแต่ 7 คะแนนขึ้นไป: " + countPass + " คน");
        // 6. รายชื่อนักศึกษาที่ควรได้รับการทบทวนเพิ่มเติม (คะแนนต่ำกว่า 5)
        System.out.print("6. รายชื่อนักศึกษาที่ควรได้รับการทบทวนเพิ่มเติม (ต่ำกว่า 5): ");
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 5) {
                System.out.print("คนที่ " + (i + 1) + " (" + scores[i] + " คะแนน) ");
            }
        }
        System.out.println();
    }
}
```

---

# สิ่งที่ต้องทำ

### 1. คะแนนรวมของนักศึกษาทั้งหมด
```java
// 1. คะแนนรวมของนักศึกษาทั้งหมด
System.out.println("1. คะแนนรวมของนักศึกษาทั้งหมด: " + totalScore + " คะแนน");
```

### 2. คะแนนเฉลี่ย
```java
// 2. คะแนนเฉลี่ย
System.out.println("2. คะแนนเฉลี่ย: " + averageScore + " คะแนน");
```

### 3. คะแนนสูงสุด
```java
// 3. คะแนนสูงสุด
System.out.println("3. คะแนนสูงสุด: " + maxScore + " คะแนน");
```

### 4. คะแนนต่ำสุด
```java
// 4. คะแนนต่ำสุด
System.out.println("4. คะแนนต่ำสุด: " + minScore + " คะแนน");
```

### 5. จำนวนนักศึกษาที่ได้คะแนนตั้งแต่ 7 คะแนนขึ้นไป
```java
// 5. จำนวนนักศึกษาที่ได้คะแนนตั้งแต่ 7 คะแนนขึ้นไป
System.out.println("5. จำนวนนักศึกษาที่ได้คะแนนตั้งแต่ 7 คะแนนขึ้นไป: " + countPass + " คน");
```

### 6. รายชื่อนักศึกษาที่ควรได้รับการทบทวนเพิ่มเติม (คะแนนต่ำกว่า 5)
```java
// 6. รายชื่อนักศึกษาที่ควรได้รับการทบทวนเพิ่มเติม (คะแนนต่ำกว่า 5)
System.out.print("6. รายชื่อนักศึกษาที่ควรได้รับการทบทวนเพิ่มเติม (ต่ำกว่า 5): ");
for (int i = 0; i < scores.length; i++) {
    if (scores[i] < 5) {
        System.out.print("คนที่ " + (i + 1) + " (" + scores[i] + " คะแนน) ");
    }
}
System.out.println();
```
## กรณีศึกษาที่ 2: Stack 
```java
import java.util.Stack;

public class StackCaseStudy {
    public static void main(String[] args) {
        Stack<String> undoStack = new Stack<>();

        // 1. เพิ่มคำสั่งทั้งหมดลงใน Stack
        undoStack.push("Type Data");
        undoStack.push("Type Structure");
        undoStack.push("Delete Structure");
        undoStack.push("Type Algorithm");
        undoStack.push("Type Java");

        System.out.println("--- กรณีศึกษาที่ 2: ระบบ Undo ในโปรแกรมจดบันทึก ---");
        
        // 2. แสดงคำสั่งทั้งหมดใน Stack
        System.out.println("คำสั่งทั้งหมดใน Stack: " + undoStack);

        // 3 & 6. Undo คำสั่งล่าสุด 2 ครั้ง พร้อมตรวจสอบก่อน pop() ว่า Stack ว่างหรือไม่
        System.out.println("\nกำลังเรียกใช้ Undo 2 ครั้ง...");
        for (int i = 1; i <= 2; i++) {
            if (!undoStack.isEmpty()) {
                String undoneCommand = undoStack.pop();
                // 4. แสดงคำสั่งที่ถูก Undo
                System.out.println("คำสั่งที่ถูก Undo: " + undoneCommand);
            } else {
                System.out.println("Stack ว่างเปล่า ไม่สามารถ Undo ได้");
            }
        }

        // 5. แสดงสถานะของ Stack หลังจาก Undo
        System.out.println("\nสถานะของ Stack หลังจาก Undo: " + undoStack);

        // 7. อธิบายว่า Stack ใช้หลักการ LIFO อย่างไร
        System.out.println("\nคำอธิบายหลักการ LIFO ของ Stack:");
        System.out.println("Stack ทำงานตามหลักการ LIFO (เข้าหลังสุด ออกก่อนสุด) " +
                "คำสั่งล่าสุดที่ถูกเพิ่มเข้าไป (Type Java) จะอยู่บนสุดของ Stack " +
                "และจะเป็นคำสั่งแรกที่ถูกยกเลิก (นำออก) เมื่อมีการเรียกใช้คำสั่ง Undo เสมอ");
    }
}
```


# สิ่งที่ต้องทำ

### เพิ่มคำสั่งทั้งหมดลงใน Stack
```java
// 1. เพิ่มคำสั่งทั้งหมดลงใน Stack
        undoStack.push("Type Data");
        undoStack.push("Type Structure");
        undoStack.push("Delete Structure");
        undoStack.push("Type Algorithm");
        undoStack.push("Type Java");

        System.out.println("--- กรณีศึกษาที่ 2: ระบบ Undo ในโปรแกรมจดบันทึก ---");
```

### แสดงคำสั่งทั้งหมดใน Stack
```java
// 2. แสดงคำสั่งทั้งหมดใน Stack
        System.out.println("คำสั่งทั้งหมดใน Stack: " + undoStack);
```

### Undo คำสั่งล่าสุด 2 ครั้ง & 6. ตรวจสอบก่อน pop() ว่า Stack ว่างหรือไม่
```java
// 3 & 6. Undo คำสั่งล่าสุด 2 ครั้ง พร้อมตรวจสอบก่อน pop() ว่า Stack ว่างหรือไม่
        System.out.println("\nกำลังเรียกใช้ Undo 2 ครั้ง...");
        for (int i = 1; i <= 2; i++) {
            if (!undoStack.isEmpty()) {
                String undoneCommand = undoStack.pop();
                // 4. แสดงคำสั่งที่ถูก Undo
                System.out.println("คำสั่งที่ถูก Undo: " + undoneCommand);
            } else {
                System.out.println("Stack ว่างเปล่า ไม่สามารถ Undo ได้");
            }
        }
```

### แสดงคำสั่งที่ถูก Undo
```java
// 4. แสดงคำสั่งที่ถูก Undo
                System.out.println("คำสั่งที่ถูก Undo: " + undoneCommand);
             else {
                System.out.println("Stack ว่างเปล่า ไม่สามารถ Undo ได้");
            }
```

### แสดงสถานะของ Stack หลังจาก Undo
```java
// 5. แสดงสถานะของ Stack หลังจาก Undo
        System.out.println("\nสถานะของ Stack หลังจาก Undo: " + undoStack);
```

### อธิบายว่า Stack ใช้หลักการ LIFO อย่างไร
```java
// 7. อธิบายว่า Stack ใช้หลักการ LIFO อย่างไร
        System.out.println("\nคำอธิบายหลักการ LIFO ของ Stack:");
        System.out.println("Stack ทำงานตามหลักการ LIFO (เข้าหลังสุด ออกก่อนสุด) " +
                "คำสั่งล่าสุดที่ถูกเพิ่มเข้าไป (Type Java) จะอยู่บนสุดของ Stack " +
                "และจะเป็นคำสั่งแรกที่ถูกยกเลิก (นำออก) เมื่อมีการเรียกใช้คำสั่ง Undo เสมอ");
```
##กรณีศึกษาที่ 3 : Queue
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueCaseStudy {
    public static void main(String[] args) {
        Queue<String> patientQueue = new LinkedList<>();

        System.out.println("--- กรณีศึกษาที่ 3: ระบบคิวผู้ป่วยในคลินิกสุขภาพ ---");
        System.out.println("--- สิ่งที่ต้องทำ ---");

        // 1. เพิ่มผู้ป่วย P001 ถึง P005 ลงใน Queue
        patientQueue.add("P001");
        patientQueue.add("P002");
        patientQueue.add("P003");
        patientQueue.add("P004");
        patientQueue.add("P005");
        System.out.println("1. เพิ่มผู้ป่วย P001 ถึง P005 ลงใน Queue เรียบร้อยแล้ว");
        System.out.println("   สถานะคิว: " + patientQueue);

        // 2. เรียกผู้ป่วยออกจากคิว 2 คน & 7. ตรวจสอบก่อน remove() ว่า Queue ว่างหรือไม่
        System.out.println("\n2. และ 7. กำลังเรียกผู้ป่วยออกจากคิว 2 คน (พร้อมตรวจสอบ Queue ว่าง)...");
        for (int i = 1; i <= 2; i++) {
            if (!patientQueue.isEmpty()) {
                String servedPatient = patientQueue.remove();
                System.out.println("   เรียกผู้ป่วย: " + servedPatient + " เข้ารับบริการแล้ว");
            } else {
                System.out.println("   Queue ว่างเปล่า");
            }
        }

        // 3. เพิ่มผู้ป่วย P006 และ P007 เข้า Queue
        System.out.println("\n3. เพิ่มผู้ป่วย P006 และ P007 เข้า Queue");
        patientQueue.add("P006");
        patientQueue.add("P007");

        // 4. แสดงผู้ป่วยคนถัดไปด้วย peek()
        System.out.println("4. ผู้ป่วยคนถัดไป (peek): " + patientQueue.peek());

        // 5. แสดงจำนวนผู้ป่วยที่ยังรออยู่ด้วย size()
        System.out.println("5. จำนวนผู้ป่วยที่ยังรออยู่ (size): " + patientQueue.size() + " คน");

        // 6. แสดงสถานะของ Queue หลังจากดำเนินการทั้งหมด
        System.out.println("6. สถานะของ Queue หลังจากดำเนินการทั้งหมด: " + patientQueue);

        // 8. อธิบายว่า Queue ใช้หลักการ FIFO อย่างไร
        System.out.println("\n8. อธิบายการทำงานของ Queue (FIFO):");
        System.out.println("   Queue ใช้หลักการ FIFO (First-In, First-Out) หรือ มาก่อนได้ก่อน " +
                "ผู้ป่วยที่มาถึงคนแรกคือ 'P001' จะถูกจัดให้อยู่หน้าสุดของคิว " +
                "ดังนั้นเมื่อเรียกคิว 'P001' จะได้รับบริการเป็นคนแรกครับ");
    }
}
```
# สิ่งที่ต้องทำ

### เพิ่มผู้ป่วย P001 ถึง P005 ลงใน Queue
```java
// 1. เพิ่มผู้ป่วย P001 ถึง P005 ลงใน Queue
        patientQueue.add("P001");
        patientQueue.add("P002");
        patientQueue.add("P003");
        patientQueue.add("P004");
        patientQueue.add("P005");
        System.out.println("1. เพิ่มผู้ป่วย P001 ถึง P005 ลงใน Queue เรียบร้อยแล้ว");
        System.out.println("   สถานะคิว: " + patientQueue);
```

### เรียกผู้ป่วยออกจากคิว 2 คน & ตรวจสอบก่อน remove() ว่า Queue ว่างหรือไม่
```java
// 2. เรียกผู้ป่วยออกจากคิว 2 คน & 7. ตรวจสอบก่อน remove() ว่า Queue ว่างหรือไม่
        System.out.println("\n2. และ 7. กำลังเรียกผู้ป่วยออกจากคิว 2 คน (พร้อมตรวจสอบ Queue ว่าง)...");
        for (int i = 1; i <= 2; i++) {
            if (!patientQueue.isEmpty()) {
                String servedPatient = patientQueue.remove();
                System.out.println("   เรียกผู้ป่วย: " + servedPatient + " เข้ารับบริการแล้ว");
            } else {
                System.out.println("   Queue ว่างเปล่า");
            }
        }
```

### เพิ่มผู้ป่วย P006 และ P007 เข้า Queue
```java
// 3. เพิ่มผู้ป่วย P006 และ P007 เข้า Queue
        System.out.println("\n3. เพิ่มผู้ป่วย P006 และ P007 เข้า Queue");
        patientQueue.add("P006");
        patientQueue.add("P007");
```

### แสดงผู้ป่วยคนถัดไปด้วย peek()
```java
// 4. แสดงผู้ป่วยคนถัดไปด้วย peek()
        System.out.println("4. ผู้ป่วยคนถัดไป (peek): " + patientQueue.peek());
```

### แสดงจำนวนผู้ป่วยที่ยังรออยู่ด้วย size()
```java
// 5. แสดงจำนวนผู้ป่วยที่ยังรออยู่ด้วย size()
        System.out.println("5. จำนวนผู้ป่วยที่ยังรออยู่ (size): " + patientQueue.size() + " คน");
```

### แสดงสถานะของ Queue หลังจากดำเนินการทั้งหมด
```java
// 6. แสดงสถานะของ Queue หลังจากดำเนินการทั้งหมด
        System.out.println("6. สถานะของ Queue หลังจากดำเนินการทั้งหมด: " + patientQueue);
```

### อธิบายว่า Queue ใช้หลักการ FIFO อย่างไร
```java
// 8. อธิบายว่า Queue ใช้หลักการ FIFO อย่างไร
        System.out.println("\n8. อธิบายการทำงานของ Queue (FIFO):");
        System.out.println("   Queue ใช้หลักการ FIFO (First-In, First-Out) หรือ มาก่อนได้ก่อน " +
                "ผู้ป่วยที่มาถึงคนแรกคือ 'P001' จะถูกจัดให้อยู่หน้าสุดของคิว " +
                "ดังนั้นเมื่อเรียกคิว 'P001' จะได้รับบริการเป็นคนแรกครับ");
```
