package chapter1;

public class StringRotation {

    public static boolean isRotation(String s1, String s2) {
        if(s1 == null || s1.length() == 0) {
            return false;
        }

        if(s1.length() == s2.length()) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
}
