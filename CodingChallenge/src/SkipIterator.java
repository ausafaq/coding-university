import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SkipIterator implements Iterator {
    private final Iterator<Integer> iterator;
    private final Map<Integer, Integer> count;
    private Integer nextElement;

    public SkipIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.count = new HashMap<>();
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }

    @Override
    public Object next() {
        if(!hasNext()) throw new RuntimeException("empty");
        Integer element = nextElement;
        advance();
        return element;
    }

    public void skip(int num) {
        if(!hasNext()) throw new RuntimeException("empty");
        if(nextElement == num) {
            advance();
        } else {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
    }

    private void advance() {
        nextElement = null;
        while(nextElement == null && iterator.hasNext()) {
            Integer element = iterator.next();
            if(!count.containsKey(element)) {
                nextElement = element;
            } else {
                count.put(element, count.get(element) - 1);
                count.remove(element, 0);
            }
        }
    }

    public static void main(String[] args) {
        SkipIterator it = new SkipIterator(Arrays.asList(1, 2, 3).iterator());
        System.out.println(it.hasNext());
        it.skip(2);
        it.skip(1);
        it.skip(3);
        System.out.println(it.hasNext());
    }
}
