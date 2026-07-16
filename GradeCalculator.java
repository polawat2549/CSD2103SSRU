import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter midterm score: ");
        int midterm = scanner.nextInt();
        System.out.print("Enter final score: ");
        int finalScore = scanner.nextInt();

        int total = midterm + finalScore;
        System.out.println("Total score = " + total);

        if (total >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        scanner.close();
    }
}