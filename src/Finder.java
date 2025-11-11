import java.io.BufferedReader;
import java.io.IOException;
/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";

    private Hashmap map;

    public Finder() {
        map = new Hashmap();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line = br.readLine();

        while (line != null) {
            String[] data = line.split(",");
            map.add(data[keyCol], data[valCol]);
            line = br.readLine();
        }

        br.close();
    }

    public String query(String key) {
        if (map.get(key) != null) {
            return map.get(key);
        }

        return INVALID;
    }
}