package chapter1;
import java.util.Arrays;

public class URLify {

    public static String replaceSpaces(String s) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith"));
    }
}
