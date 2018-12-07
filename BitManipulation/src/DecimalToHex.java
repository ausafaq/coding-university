import java.util.*;

public class DecimalToHex {

    public static String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder hexNum = new StringBuilder(100);
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (num != 0) {
            char c = map[num & 15];
            hexNum.append(c);
            num = (num >>> 4);
        }
        return hexNum.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(-1));
    }
}
