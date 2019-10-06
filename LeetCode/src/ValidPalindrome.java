public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int len = s.length();

        for(int i = 0; i < len/2; i++) {
            if(arr[i] != arr[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("manam"));
    }

}
