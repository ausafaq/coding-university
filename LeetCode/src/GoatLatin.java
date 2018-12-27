public class GoatLatin {

    public static String toGoatLatin(String S) {
        String[] strArr = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strArr.length; i++) {
            if ("aeiouAEIOU".contains(strArr[i].substring(0,1))) {
                sb.append(strArr[i] + "ma");
            } else {
                sb.append(strArr[i].substring(1) + strArr[i].substring(0,1) + "ma");
            }

            for(int j = 0; j <= i; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String input = "I speak Goat Latin";
        System.out.println(toGoatLatin(input));

    }
}
