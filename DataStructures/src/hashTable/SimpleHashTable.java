package hashTable;

public class SimpleHashTable<K, V> {

    class Entry<K, V> {
        K key;
        V value;
        Entry next;
    }

    private Entry[] buckets;
    private int size;

    // Constructor
    public SimpleHashTable(int capacity) {
        buckets = new Entry[capacity];
        size = 0;
    }

    private int hashFunction(int hashCode) {
        int index = hashCode;
        if(index < 0) index = -index;
        return index % buckets.length;
    }

    // Add a node
    public boolean put(K key, V value) {

        int index = hashFunction(key.hashCode());
        Entry current = buckets[index];
        while(current != null) {
            if(current.key.equals(key)) {
                return false;
            }
            current = current.next;
        }
        Entry entry = new Entry();
        entry.key = key;
        entry.value = value;
        entry.next = buckets[index];
        buckets[index] = entry;
        size++;

        return true;
    }

    // Remove a node
    public boolean remove(K key) {
        int index = hashFunction(key.hashCode());
        Entry current = buckets[index];
        Entry previous = null;

        while(current != null) {
            if(current.key.equals(key)) {
                if(previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    // Check if contains node
    public boolean containsKey(K key) {
        int index = hashFunction(key.hashCode());
        Entry current = buckets[index];

        while(current != null) {
            if(current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Retrieve a node
    public V get(K key) {
        int index = hashFunction(key.hashCode());
        Entry current = buckets[index];

        while(current != null) {
            if(current.key.equals(key)) {
                V value = (V) current.value;
                return value;
            }
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Printing the HashTable
    @Override
    public String toString() {
        Entry currentEntry = null;
        StringBuilder sb = new StringBuilder();
        for(int index = 0; index < buckets.length; index++) {
            if(buckets[index] != null) {
                currentEntry = buckets[index];

                while(currentEntry != null) {
                    sb.append("[" + index + "]");
                    sb.append(" " + currentEntry.key.toString() + "->" + currentEntry.value.toString());
                    currentEntry = currentEntry.next;
                }
            }
        }
        return sb.toString();
    }


}
