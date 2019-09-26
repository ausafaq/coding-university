import java.util.Arrays;

public class WordsByCharacters {
    public static int countCharacters(String[] words, String chars) {
        int[] charMap = new int[26];
        for(int i = 0; i < chars.length(); i++) {
            charMap[chars.charAt(i) - 'a']++;
        }
        int goodCount = 0;
        for (String word: words) {
            if(word.length() <= chars.length()) {
                int[] charMapClone = charMap.clone();
                for(int j = 0; j < word.length(); j++) {
                    if(charMapClone[word.charAt(j) - 'a'] > 0) {
                        charMapClone[word.charAt(j) - 'a']--;
                    } else {
                        break;
                    }
                    if(j == word.length() - 1) {
                        goodCount += word.length();
                    }
                }
            }
        }
        return goodCount;
    }


    public static void main(String[] args) {
       String[] words = {"hello","world","leetcode"};
       String charList = "welldonehoneyr";
        System.out.println(countCharacters(words, charList));
    }
}
