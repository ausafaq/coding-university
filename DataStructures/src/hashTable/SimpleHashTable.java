package hashTable;

public class SimpleHashTable {

    private HashNode[] hashTable;
    private int size;

    // Constructor
    public SimpleHashTable() {

        hashTable = new HashNode[10];
    }

    //Hashing function
    private int hashKey(String key) {

        return key.length() % hashTable.length;
    }

    // Add a node
    public void put(String key, HashNode node) {
        int hashedKey = hashKey(key);
        if(hashTable[hashedKey] != null) {
            System.out.println("Sorry, there's already a node at position " +hashedKey);
        } else {
            hashTable[hashedKey] = node;
            size++;
        }
    }

    // Remove a node
    public void remove(String key) {
        int hashedKey = hashKey(key);
        hashTable[hashedKey] = null;
    }

    // Retrieve a node
    public HashNode get(String key) {
        int hashedKey = hashKey(key);
        return hashTable[hashedKey];
    }

    // Printing the HashTable
    public void printHashTable() {
        for(int i = 0; i < hashTable.length; i++) {
            if(hashTable[i] != null) {
                HashNode node = hashTable[i];
                System.out.println(node.key + " -> " + node.value);
            } else {
                System.out.println(hashTable[i]);
            }
        }
    }


}
