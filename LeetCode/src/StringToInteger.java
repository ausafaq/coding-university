public class StringToInteger {

    public static int myAtoi(String str) {
        double result = 0;
        int sign = 1;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (double) (str.charAt(i) - '0');
            i++;
        }

        result = result * sign;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-534"));
    }
}
