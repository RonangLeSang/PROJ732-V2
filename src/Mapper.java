import java.util.ArrayList;
import java.util.HashMap;

public class Mapper implements Runnable{

    private WordCounter counter;
    private HashMap<String, Integer> wordCount = null;

    public Mapper(ArrayList<String> text) {
        this.counter = new WordCounter(text);
    }

    @Override
    public void run() {
        this.wordCount = counter.count();
    }
}
