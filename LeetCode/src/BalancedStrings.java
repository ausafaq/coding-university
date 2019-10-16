public class BalancedStrings {

    public static int balancedStringSplit(String s) {

        int count = 0;

        int check = 0;

        for(int i = 0; i < s.length(); i++) {
            check += s.charAt(i) == 'L' ? 1 : -1;
            if(check == 0) {
                count++;
            }
        }
        return count;
    }

    public static  int balancedStringSplitCheck(String s) {
        // RLRRLLRLRL
        int count = 0;
        int R = 0, L = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R') {
                R++;
            } else if (s.charAt(i) == 'L') {
                L++;
            }
            if(L == R) {
                count++;
                R = 0;
                L = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplitCheck("RLRRLLRLRL"));
    }
}
