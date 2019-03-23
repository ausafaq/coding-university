import java.util.Arrays;

public class ReverseString {

    public static String reverseString(String str) {
        if(str == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder(str);
        int start = 0;
        int end = sb.length() - 1;

        while(start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString(null));
    }
}


