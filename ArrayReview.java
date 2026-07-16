import java.util.Scanner;

public class ArrayReview {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[5];
        int total = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
            total += scores[i];
        }

        double average = (double) total / 5;
        System.out.println("Total score = " + total);
        System.out.println("Average score = " + average);
        scanner.close();
    }
}