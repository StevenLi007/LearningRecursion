public class StringOps {
    public String stringReversal(String input) {
        if (input.equals("")) {
            return "";
        }
        return stringReversal(input.substring(1)) + input.charAt(0);
    }

    public boolean isPalindrome(String input) {
        // base case: empty string or single letter
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }

        // check first and last char, move on if equal
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }

        return false;
    }

    public static void main(String[] args) {
        StringOps obj = new StringOps();
        System.out.println(obj.stringReversal("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(obj.isPalindrome("racecar"));
    }
}