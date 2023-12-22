import java.util.ArrayList;
import java.util.HashMap;

public class WordCounter {

    private ArrayList<String> text = new ArrayList<>();
    private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

    public WordCounter(ArrayList<String> sentences){
        for(String sentence : sentences){
            String[] sentenceList = sentence.split(" ");
            for (String element : sentenceList) {
                text.add(element);
            }
        }
    }

    public HashMap count(){
        for(String word : text){
            System.out.println(text);
            if(wordCount.containsKey(word)){
                wordCount.put(word, wordCount.get(word)+1);
            }else{
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }

}
