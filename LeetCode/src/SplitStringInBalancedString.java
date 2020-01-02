public class SplitStringInBalancedString {

    public static int balancedStringSplit(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int count = 0;
        int R = 0, L = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R') {
                R++;
            } else if (s.charAt(i) == 'L') {
                L++;
            }
            if(R == L) {
                count++;
                R = 0;
                L = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }
}
