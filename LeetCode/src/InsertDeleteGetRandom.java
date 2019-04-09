import java.util.*;

public class InsertDeleteGetRandom {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;
    private int size;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
        size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        size++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        if(index == size - 1) {
            list.remove(--size);
            map.remove(val);
            return true;
        }
        int num = list.remove(--size);
        list.set(index,num);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(size));
    }

}
