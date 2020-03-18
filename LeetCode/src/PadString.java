import java.util.Arrays;

public class PadString {

    public static String padLeftZero(String str, int padding) {
        StringBuilder sb = new StringBuilder();

        while(sb.length() < (padding - str.length())) {
            sb.append("0");
        }
        sb.append(str);

        return sb.toString();
    }

    public static String padRightZero(String str, int padding) {
        StringBuilder sb = new StringBuilder();

        sb.append(str);
        while(sb.length() < padding) {
            sb.append("0");
        }

        return sb.toString();
    }

    public static String padSpaces(String str, int padding) {
        String[] inputArr = str.split(" ");

        int letterCount = 0;
        for(String s : inputArr) {
            letterCount += s.length();
        }

        int space = inputArr.length - 1;
        int padSpace = padding - letterCount;
        int padCnt = padSpace / space;
        int padMod = padSpace % space;

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < inputArr.length - 1) {
            sb.append(inputArr[i]);
            for(int j = 0; j < padCnt; j++) {
                sb.append("0");
            }
            if(padMod != 0) {
                sb.append("0");
                padMod--;
            }
            i++;
        }
        sb.append(inputArr[i]);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(padLeftZero("Hello", 10));
        System.out.println(padRightZero("Hello", 10));
        System.out.println(padSpaces("Hello World!", 17));
    }
}
