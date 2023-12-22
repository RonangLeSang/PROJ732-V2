import java.util.ArrayList;
import java.util.HashMap;

public class Reducer {

    private ArrayList<HashMap<String, Integer>> hashList;
    private HashMap<String, Integer> fullHashMap = new HashMap<>();

    public Reducer(ArrayList<HashMap<String, Integer>> hashList) {
        this.hashList = hashList;
    }

    public HashMap<String, Integer> testMerge() {
        for (HashMap<String, Integer> hash : hashList) {
            hash.forEach((key, value) -> fullHashMap.merge(key, value, Integer::sum));
        }
        return fullHashMap;
    }
}