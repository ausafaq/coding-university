public class BinaryGap {

    public static int binaryGap(int N) {
        String bin = helper(N);
        char[] digits = bin.toCharArray();
        int i = 0, j = 1;
        int result = 0;
        while(j < digits.length) {

            if(digits[i] == '1') {
                if(digits[j] == '1') {
                    result = Math.max(result, j - i);
                    i = j;
                    j = i + 1;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    // Decimal Integer to binary string
    private static String helper(int n) {
        String s = "";
        while(n != 0) {
            s = n % 2 + s;
            n = n / 2;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
    }
}
