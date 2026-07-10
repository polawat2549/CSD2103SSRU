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