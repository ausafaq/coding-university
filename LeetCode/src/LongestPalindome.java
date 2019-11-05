public class LongestPalindome {

    public static String longestPalindrome(String s) {

        if(s==null || s.length()<1) {
            return "";
        }

        String longest = s.substring(0, 1);

        for(int i = 0; i < s.length(); i++) {
            String temp = expandAroundCenter(s, i, i);

            if(temp.length() > longest.length()) {
                longest = temp;
            }

            temp = expandAroundCenter(s, i , i + 1);
            if(temp.length() > longest.length()) {
                longest = temp;
            }
        }

        return longest;
    }


    private static String expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return s.substring(L+1, R);
    }

    public static void main(String[] args) {
        String s = "babad";

        System.out.println(longestPalindrome(s));
    }
}
