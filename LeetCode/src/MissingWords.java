import java.util.*;

public class MissingWords {

    private static List<String> missingWords(String s, String t) {
        List<String> missingWords = new ArrayList<>();
        String[] superSetArr = s.split(" ");
        String[] subSetArr = t.split(" ");

        int sub = 0;
        int sup = 0;

        while (sub < subSetArr.length && sup < superSetArr.length) {
            if(superSetArr[sup].trim().equals(subSetArr[sub])) {
                sup++;
                sub++;
            } else {
                missingWords.add(superSetArr[sup]);
                sup++;
            }
        }

        //Remaining entries in the superset
        while(sup < superSetArr.length) {
            missingWords.add(superSetArr[sup]);
            sup++;
        }
        return missingWords;

    }

    public static void main(String[] args) {
        String s = "I am using HackerRank to improve programming";
        String t = "am HackerRank to improve";

        System.out.println(missingWords(s,t));
    }
}
