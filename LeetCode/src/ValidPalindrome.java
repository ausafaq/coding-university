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

    public static boolean isPalindromeII(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int i = 0;
        int j = arr.length - 1;

        while(i < j) {
            while((i <= arr.length - 1) && !((arr[i] >='a' && arr[i] <= 'z') || (arr[i]>='0'&& arr[i]<='9'))) {
                i++;
            }

            while((j >= 0) && !((arr[j] >='a' && arr[j] <= 'z') || (arr[i]>='0'&& arr[i]<='9'))) {
                j--;
            }

            if(arr[i++] != arr[j--]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeII("race a car"));
    }

}
