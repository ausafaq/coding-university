public class SegmentsInAString {

    public static int countSegments(String s) {
        String trimmed = s.trim();
        if(trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }
}
