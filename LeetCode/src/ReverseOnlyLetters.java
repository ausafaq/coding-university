import java.util.Arrays;

public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c))
                sb.append(c);
        }
        sb.reverse();
        for (int i = 0; i < S.length(); ++i) {
            if (!Character.isLetter(S.charAt(i)))
                sb.insert(i, S.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String output = reverseOnlyLetters("ab-cd");
        System.out.println(output);
    }
}
