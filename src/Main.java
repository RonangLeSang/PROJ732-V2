import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Coordinator coordinator = new Coordinator();
        String text = coordinator.read("data/text_AnewYou.txt");
        Splitter splitter = new Splitter();
        ArrayList<String> splittedSentences = splitter.splitPhrases(splitter.normalization(text));
        Mapper mapper1 = new Mapper(splittedSentences);
        Mapper mapper2 = new Mapper(splittedSentences);

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
    }
}
