# Lab Report: Singly Linked List (Node1)

ใบงานการทดลองเขียนและจัดการข้อมูลประเภท Singly Linked List ด้วยภาษา Java โดยสร้างคลาส `Node1<T>` แบบ Generics

## การทำงานของโปรแกรม

1. **การสร้างและเชื่อมต่อ Node**
   - สร้าง Node: `red`, `yellow`, `green`, `pink`
   - เชื่อมต่อตามลำดับ: `red` -> `yellow` -> `green` -> `pink`

2. **การค้นหา Node (`searchNode`)**
   - วนลูปหาค่าที่ต้องการ (เช่น `"blue"`)
   - คืนค่า Node ที่พบ หากไม่พบจะคืนค่า `null`

3. **การนับจำนวน Node (`countNodes`)**
   - วนลูปนับจำนวน Node ทั้งหมดใน List ตั้งแต่ Head จนถึง Tail

## วิธีการรันโปรแกรม

1. บันทึกไฟล์ชื่อ `Node1.java`
2. คอมไพล์และสั่งรันผ่าน Terminal:

```bash
javac Node1.java
java Node1
```
```
##ผลลัพธ์ที่ได้
p = Node1@6d06d69c
p.nodeValue = red
p.next before = null
q = Node1@7852e922
q.nodeValue = green
q.next = null
p.next After = Node1@4eec7777
n.next After = Node1@7852e922
head. = Node1@6d06d69c
q.next After = Node1@70325e14
teil. = Node1@70325e14
search 'blue' = null
count nodes = 4
```
