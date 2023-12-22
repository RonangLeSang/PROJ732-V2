import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static ArrayList<Mapper> createWorkers(int nbWorkers){
        ArrayList<Mapper> workers = new ArrayList<Mapper>();
        for(int i = 0; i < nbWorkers; i++){
            workers.add(new Mapper());
        }
        return workers;
    }

    public static void startWorkers(ArrayList<Mapper> workers, ArrayList<ArrayList<String>> splittedWork){
        for(int i = 0; i < workers.size(); i++){
            workers.get(i).setText(splittedWork.get(i));
            workers.get(i).start();
        }
    }

    public static void isFinished(ArrayList<Mapper> workers){
        try{
            for(Mapper worker : workers){
                worker.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Coordinator coordinator = new Coordinator();
        String text = coordinator.read("data/text_AnewYou.txt");
        Splitter splitter = new Splitter();
        ArrayList<String> splittedSentences = splitter.splitPhrases(splitter.normalization(text));

        ArrayList<Mapper> workers = Main.createWorkers(2);

        ArrayList<ArrayList<String>> splittedWork = new ArrayList<ArrayList<String>>();

        startWorkers(workers, splittedWork);

        // Wait for both threads to finish
        isFinished(workers);

//        ArrayList<HashMap<String, Integer>> hashList = new ArrayList<HashMap<String, Integer>>();
//        hashList.add(mapper1.getWordCount());
//        hashList.add(mapper2.getWordCount());
//
//        Reducer reduce = new Reducer(hashList);
//        System.out.println(reduce.testMerge());
    }
}
