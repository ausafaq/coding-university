/* 1's and 2's complement of a binary number */

public class TwosAndOnesComplement {

    private static char flip(char c) {
        return (c == '0' ? '1' : '0');
    }

    public static String onesComplement(String s) {
        String ones = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {
            ones += flip(s.charAt(i));
        }
        return ones;
    }

    public static String twosComplement(String s) {
        StringBuilder builder = new StringBuilder(onesComplement(s));
        int n = s.length();
        boolean flag = false;
        for (int i = n - 1; i >= 0; i--) {
            if (builder.charAt(i) == '1') {
                builder.setCharAt(i, '0');
            } else {
                builder.setCharAt(i, '1');
                flag = true;
                break;
            }
        }

        if (!flag) {
            String zeros = "";
            String twos = "1";
            for (int j = 0; j < n; j++) {
                zeros += '0';
            }

            twos = twos.concat(zeros);
            return twos;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String bin = "1100";
        System.out.println(twosComplement(bin));

    }
}
