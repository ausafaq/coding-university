package StringBuilder;

import java.util.ArrayList;
import java.util.List;

public class StringBuilder {

    private List<Character> characterBuffer;

    public StringBuilder() {

        characterBuffer = new ArrayList<Character>();
    }

    public void append(String anotherString) {
        if(anotherString != null) {
            char[] charArray = anotherString.toCharArray();
            for(int i=0;i<charArray.length; i++) {
                characterBuffer.add(charArray[i]);
            }
        }
    }

    public String toString() {
        char[] charArray = new char[characterBuffer.size()];
        for(int i=0; i<charArray.length; i++) {
            charArray[i] = characterBuffer.get(i);
        }
        return new String(charArray);
    }

}