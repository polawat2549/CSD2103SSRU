import java.util.Scanner;

public class Problem3 {


    public static boolean hasMoreVowelsRecursive(String s) {
        if (s == null) return false;

        return countRecursive(s.toLowerCase(), 0, 0, 0);
    }


    private static boolean countRecursive(String s, int index, int vowels, int consonants) {

        if (index >= s.length()) {
            return vowels > consonants;
        }

        char c = s.charAt(index);


        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }


        return countRecursive(s, index + 1, vowels, consonants);
    }


    public static boolean hasMoreVowelsIterative(String s) {
        if (s == null) return false;

        int vowels = 0;
        int consonants = 0;
        String lowerS = s.toLowerCase();


        for (int i = 0; i < lowerS.length(); i++) {
            char c = lowerS.charAt(i);


            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        return vowels > consonants;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("กรอกข้อความที่ต้องการตรวจสอบ: ");
        String input = scanner.nextLine();

        System.out.println("\n=== ผลการทดสอบ ===");
        System.out.println("Input String      : " + input);
        System.out.println("Recursive Result  : " + hasMoreVowelsRecursive(input));
        System.out.println("Iterative Result  : " + hasMoreVowelsIterative(input));

        scanner.close();
    }
}