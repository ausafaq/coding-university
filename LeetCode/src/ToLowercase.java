public class ToLowercase {

    public static String toLowercase(String str) {
        for(int i = 0; i < str.length(); i++) {
            if((int)str.charAt(i) > 64 && (int)str.charAt(i) < 91) {
                str = str.replace(str.charAt(i), (char)((int)(str.charAt(i) + 32)));
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(toLowercase("HELLo"));
    }
}
