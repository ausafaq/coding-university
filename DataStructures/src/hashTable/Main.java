package hashTable;

public class Main {

    public static void main(String[] args) {
        HashNode nodeOne = new HashNode("Ahmed", "Ausaf");
        HashNode nodeTwo = new HashNode("Doe", "John");
        HashNode nodeThree = new HashNode("Monroe", "Donna");

        SimpleHashTable table = new SimpleHashTable();

        table.put("Ahmed", nodeOne);
        table.put("Doe", nodeTwo);
        table.put("Monroe", nodeThree);

        //table.printHashTable();
        System.out.println(table.get("Ahmed"));

    }
}
