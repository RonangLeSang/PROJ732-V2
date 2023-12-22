import java.util.ArrayList;
import java.util.HashMap;

public class Mapper extends Thread{

    private WordCounter counter;
    private HashMap<String, Integer> wordCount = null;

    public Mapper(ArrayList<String> text) {
        this.counter = new WordCounter(text);
    }

    public Mapper() {
        this.counter = new WordCounter();
    }

    public void setText(ArrayList<String> text){
        this.counter.setText(text);
    }

    public HashMap<String, Integer> getWordCount() {
        return wordCount;
    }

    @Override
    public void run() {
        this.wordCount = counter.count();
    }
}
