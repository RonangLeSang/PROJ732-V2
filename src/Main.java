import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> hash1 = new HashMap<String, Integer>();
        hash1.put("feur", 4);
        hash1.put("carlos", 4);
        hash1.put("andres", 4);
        hash1.put("cortes", 4);
        hash1.put("miranda", 4);

        HashMap<String, Integer> hash2 = new HashMap<String, Integer>();
        hash2.put("feur", 4);
        hash2.put("andres", 4);
        hash2.put("ronan", 4);
        hash2.put("ciao", 4);
        hash2.put("explosion", 4);

        ArrayList<HashMap<String, Integer>> fullHashMap = new ArrayList<HashMap<String, Integer>>();

        fullHashMap.add(hash1);
        fullHashMap.add(hash2);

        Reducer reduce = new Reducer(fullHashMap);
        System.out.println(reduce.testMerge());
    }

}