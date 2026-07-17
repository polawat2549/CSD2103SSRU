# ใบงานทบทวนภาษา Java
 
เอกสารนี้สรุปรายละเอียดของโปรแกรม Java ทั้งหมดที่จัดทำขึ้นตามใบงานทบทวนภาษา Java เพื่อเตรียมความพร้อมก่อนเรียนเรื่องอัลกอริทึม
 
 
## 1. EvenOddChecker.java
โปรแกรมตรวจสอบเลขคู่หรือเลขคี่
 
**Input**
 ตัวเลขจำนวนเต็ม 1 จำนวน (รับจากผู้ใช้ผ่าน Scanner)
**Process**
 รับค่าตัวเลขจากผู้ใช้
 ตรวจสอบด้วยเงื่อนไข `if-else` ว่าตัวเลขหารด้วย 2 ลงตัวหรือไม่ (`number % 2 == 0`)
**Output**
```
Enter number: 8
Even number
```
 
**วิธีรันโปรแกรม**
```
javac EvenOddChecker.java
java EvenOddChecker
```
 
**สิ่งที่ได้เรียนรู้**
 การใช้คำสั่ง `if-else` เพื่อตัดสินใจเงื่อนไข
 การใช้ตัวดำเนินการ modulo (`%`) เพื่อตรวจสอบเลขคู่/เลขคี่

 
## 2. GradeCalculator.java
โปรแกรมคำนวณคะแนนรวมและตัดสินผลผ่าน/ไม่ผ่าน
 
**Input**
 คะแนนกลางภาค (midterm)
 คะแนนปลายภาค (final)
**Process**
 รับคะแนนกลางภาคและคะแนนปลายภาคจากผู้ใช้
 คำนวณคะแนนรวม (`total = midterm + finalScore`)
 ตรวจสอบเงื่อนไขว่าคะแนนรวมตั้งแต่ 50 คะแนนขึ้นไปหรือไม่
**Output**
```
Enter midterm score: 25
Enter final score: 30
Total score = 55
Pass
```
 
**วิธีรันโปรแกรม**
```
javac GradeCalculator.java
java GradeCalculator
```
 
**สิ่งที่ได้เรียนรู้**
การรับค่าตัวเลขหลายค่าด้วย Scanner
การใช้เงื่อนไข `if-else` ร่วมกับการคำนวณผลรวม
การตัดสินผลลัพธ์ตามเกณฑ์ที่กำหนด

 
## 3. ArrayReview.java
โปรแกรมทบทวน Array: รับคะแนนนักศึกษา 5 คน คำนวณคะแนนรวมและค่าเฉลี่ย
 
**Input**
- คะแนนของนักศึกษา 5 คน (รับทีละค่า)
**Process**
 สร้าง Array ขนาด 5 สำหรับเก็บคะแนน
 วนลูป `for` เพื่อรับคะแนนทีละคนและสะสมผลรวม
 คำนวณค่าเฉลี่ยจากผลรวมหารด้วยจำนวนคน
**Output**
```
Enter score 1: 70
Enter score 2: 80
Enter score 3: 65
Enter score 4: 90
Enter score 5: 75
Total score = 380
Average score = 76.0
```
 
**วิธีรันโปรแกรม**
```
javac ArrayReview.java
java ArrayReview
```
 
**สิ่งที่ได้เรียนรู้**
 การประกาศและใช้งาน Array ในภาษา Java
 การวนลูป `for` เพื่อรับค่าและประมวลผลข้อมูลใน Array
 การแปลงชนิดข้อมูล (type casting) เพื่อคำนวณค่าเฉลี่ยแบบทศนิยม

 
## 4. MiniChallenge.java
โปรแกรมนับจำนวนเลขคู่และเลขคี่ (Mini Challenge ตัวเลือกที่ 1)
 
**Input**
ตัวเลขจำนวนเต็ม 10 จำนวน (รับทีละค่า)
**Process**
สร้าง Array ขนาด 10 สำหรับเก็บตัวเลข
วนลูป `for` เพื่อรับค่าตัวเลขทีละจำนวน
**Output**
```
Enter number 1: 2
Enter number 2:50
Enter number 3:61
Enter number 4:4
Enter number 5:52
Enter number 6:78
Enter number 7:10
Enter number 8:35
Enter number 9: 96
Enter number 10: 55
Even count = 7
Odd count = 3
```
 
**วิธีรันโปรแกรม**
```
javac MiniChallenge.java
java MiniChallenge
```
 
**สิ่งที่ได้เรียนรู้**
การใช้ Array ร่วมกับลูป `for` เพื่อประมวลผลข้อมูลชุดใหญ่
การใช้ตัวแปรตัวนับ (counter) เพื่อสรุปผลข้อมูล

