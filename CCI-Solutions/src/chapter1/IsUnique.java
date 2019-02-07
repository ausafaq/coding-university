package chapter1;

public class IsUnique {

    public static boolean uniqueString(String str) {

        if(str == null && str.length() == 0) {
            return false;
        }

        boolean[] charSet = new boolean[128];

        for(int i = 0 ; i < str.length(); i++) {
            int val = str.charAt(i);
            if(charSet[val]) {
                return false;
            }

            charSet[val] = false;
        }
        return true;
    }

    public static void main(String[] args) {

        String str = "Helo";

        System.out.println(uniqueString(str));
    }
}
