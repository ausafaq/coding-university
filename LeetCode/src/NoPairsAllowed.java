import java.util.*;

public class NoPairsAllowed {


    private static List<Integer> filter(List<String> words) {
        if (words == null) {
            return null;
        }

        if (words.size() == 0) {
            return null;
        }

        int[] result = new int[words.size()];

        for (int i = 0; i < words.size(); i++) {
            Map<Character, Integer> charMap = new HashMap<>();
            for (int j = 0; j < words.get(i).length(); j++) {
                if (charMap.get(words.get(i).charAt(j)) == null) {
                    charMap.put(words.get(i).charAt(j), j);
                } else {
                    if (charMap.get(words.get(i).charAt(j)) == j - 1) {

                        result[i] += 1;
                    } else {
                        charMap.put(words.get(i).charAt(j), j);
                    }
                }
            }
        }
        List<Integer> output = new ArrayList<>();

        for (int value : result) {
            output.add(value);
        }
        return output;
    }

    public static void main(String[] args) {
        String[] input = {"ab", "aab", "abb", "abab", "abaaaba", "booook", "break"};

        List<Integer> output = filter(Arrays.asList(input));

        System.out.println(output);

    }
}
