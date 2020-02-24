package HashTable;

public class HashNode<K, V> {
    K key;
    V value;

    // Reference to the next node
    HashNode<K, V> next;

    // Constructor
    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
