public class performStringShifts {

    public static String stringShift(String s, int[][] shift) {

        if(s == null || s.length() == 0 || shift == null) {
            return "";
        }

        int val = 0;
        int len = s.length();
        for(int i = 0; i < shift.length; i++) {
            val += shift[i][0] == 0 ? -shift[i][1] : shift[i][1];
        }

        val %= len;
        String result = "";
        if(val > 0) {
            result = s.substring(len - val, len) + s.substring(0, len - val);
        } else {
            val = Math.abs(val);
            result = s.substring(val, len) + s.substring(0, val);
        }
        return result;
    }



    public static void main(String[] args) {
        int[][] shift = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        System.out.println(stringShift("abcdefg", shift));
    }
}
