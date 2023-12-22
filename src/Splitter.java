import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.regex.*;

public class Splitter {

    public Splitter() {}


    public String normalization (String text) {
        text = text.replaceAll("[\\s&&[^\\n]]+", " ").replaceAll("\\s*,\\s*", ", ").replaceAll("\\s*\\.[\\s&&[^\n]]*", ". ").
                replaceAll("\\s*:\\s*", ": ").replaceAll("\\n+", "\n").replaceAll("^\n|\n$", "").replaceAll("[^\\sa-zA-Z0-9.]", "");
        text = text.toLowerCase();
        return text;
    }

    public ArrayList<String> splitPhrases(String text){
        return new ArrayList<String> (Arrays.asList(text.split("\\.")));
    }
}
