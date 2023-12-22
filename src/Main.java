import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> text1 = new ArrayList<>();
        text1.add("carlos andres");
        text1.add("cortes miranda feur");

        ArrayList<String> text2 = new ArrayList<>();
        text2.add("explosion feur");
        text2.add("ronan ciao andres");

        Mapper mapper1 = new Mapper(text1);
        Mapper mapper2 = new Mapper(text2);

        mapper1.start();
        mapper2.start();

        // Wait for both threads to finish
        try {
            mapper1.join();
            mapper2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<HashMap<String, Integer>> hashList = new ArrayList<HashMap<String, Integer>>();
        hashList.add(mapper1.getWordCount());
        hashList.add(mapper2.getWordCount());

        Reducer reduce = new Reducer(hashList);
        System.out.println(reduce.testMerge());

        Coordinator coordinator = new Coordinator();
        System.out.println(coordinator.read("data/text.txt"));
    }
}
