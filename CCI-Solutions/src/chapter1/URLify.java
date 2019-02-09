package chapter1;

public class URLify {

    public void replaceSpaces(String s) {
        int n = s.length();

        int spaceCount = 0;

        char[] strArr = s.toCharArray();

        for(int i =0; i < n; i++) {
            if(strArr[i] == ' ') {
                spaceCount++;
            }
        }


    }
}
