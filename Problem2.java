public class Problem2 {

    public static boolean isPalindromeByReverse(String s) {
        if (s == null) return false;


        String cleanStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();


        String reversed = new StringBuilder(cleanStr).reverse().toString();


        return cleanStr.equals(reversed);
    }


    public static boolean isPalindromeRecursive(String s, int left, int right) {

        if (left >= right) {
            return true;
        }


        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }


        return isPalindromeRecursive(s, left + 1, right - 1);
    }


    public static boolean isPalindromeRecursive(String s) {
        if (s == null) return false;

        String cleanStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanStr.isEmpty()) return true;


        return isPalindromeRecursive(cleanStr, 0, cleanStr.length() - 1);
    }

    public static void main(String[] args) {

        String input = "A man, a plan, a canal: Panama";

        System.out.println("=== Palindrome Checker Test ===");
        System.out.println("Input: " + input);
        System.out.println("----------------------------------");
        System.out.println("1. Reverse and Compare : " + isPalindromeByReverse(input));
        System.out.println("2. Recursive Two-Pointer: " + isPalindromeRecursive(input));
    }
}