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