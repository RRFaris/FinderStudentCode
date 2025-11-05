public class Hashmap {
    // Prime number
    public final int DEFAULT_TABLE_SIZE = 1009;

    public final int RADIX = 256;

    // Amount of memory table allocates
    int tableSize;

    // Amount of elements in hashmap
    int num_elements;

    String[] keys;
    String[] values;

    // Constructor
    public Hashmap() {
        tableSize = DEFAULT_TABLE_SIZE;
        num_elements = 0;

        keys = new String[tableSize];
        values = new String[tableSize];
    }

    // Horner's method
    public int hash(String key, int m) {
        int hash = 0;
        for (int i = 0; i < m; i++)
            hash = (hash * RADIX + key.charAt(i)) % tableSize;
        return hash;
    }

    // Adds a new key and value to the hashmap
    public void add(String key, String value) {
        // Add value at its index (its hash) and check for collisions

        int index = hash(key, key.length());

        while (keys[index] != null) {
            if (index == tableSize / 2)
                index = 0;
            else
                index++;
        }

        keys[index] = value;
    }

    // Returns the value stored at key in the hashmap
    public String get(String key) {


        return "";
    }

    // Double the hashmap when it is half-full
    public void resize() {

    }

}
