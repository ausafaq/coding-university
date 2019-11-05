import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int currRow = 0;
        Boolean goingDown = false;

        for(char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            if(currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();

    }

    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
