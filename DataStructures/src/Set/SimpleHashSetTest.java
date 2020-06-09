package Set;

import java.util.Iterator;
import java.util.logging.Logger;

public class SimpleHashSetTest {

    public static void main(String[] args) {
        SimpleSet fruits = new SimpleHashSet(128);
        SimpleSet numbers = new SimpleHashSet(128);
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("orange");
        System.out.println(fruits.toString());
    }

}
