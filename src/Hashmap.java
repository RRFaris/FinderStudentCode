public class Hashmap {
    // Prime number
    public final int DEFAULT_TABLE_SIZE = 1999;
    public final double ALPHA = 0.4;

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
    public int hash(String key) {
        int hash = 0;
        int length = key.length();

        for (int i = 0; i < length; i++)
            hash = (hash * RADIX + key.charAt(i)) % tableSize;
        return hash;
    }

    // Adds a new key and value to the hashmap
    public void add(String key, String value) {
        // Add value at its index (its hash) and check for collisions
        num_elements++;
        // Check to resize

        if (num_elements >= tableSize * ALPHA) {
            resize();
        }
        int index = hash(key);

        while (keys[index] != null) {
            // Don't want to overflow
            index++;
            if (index == tableSize)
                index = 0;
        }
        keys[index] = key;
        values[index] = value;

    }

    // Returns the value stored at key in the hashmap
    public String get(String key) {
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index++;
            if (index == tableSize)
                index = 0;
        }
        return values[index];
    }

    // Double the hashmap when it is half-full
    public void resize() {
        String[] oldKeys = keys;
        String[] oldValues = values;
        int oldTableSize = tableSize;

        tableSize *= 2;

        keys = new String[tableSize];
        values = new String[tableSize];

        num_elements = 0;

        for (int i = 0; i < oldTableSize; i++) {
            if (oldKeys[i] != null)
                add(oldKeys[i], oldValues[i]);
        }
    }
}
