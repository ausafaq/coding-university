import java.util.*;

public class MissingWords {

    private static List<String> missingWords(String superSet, String subSet) {
        List<String> missingWords = new ArrayList<>();
        String[] superSetArr = superSet.split(" ");
        String[] subSetArr = subSet.split(" ");

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

        String s = "I love programming";
        String t = "love";

        List<String> arr = new ArrayList<>();
        arr = missingWords(s, t);

        for(String a : arr){
            System.out.println(a);
        }

    }
}
