import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Coordinator {

    String text = "";

    public ArrayList<ArrayList<String>> splitList(ArrayList<String> listPhrases, int nbWorkers){
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        int sublistSize = listPhrases.size() / nbWorkers;
        int remainder = listPhrases.size() % nbWorkers;

        int startIndex = 0;
        for (int i = 0; i < nbWorkers; i++) {
            int endIndex = startIndex + sublistSize + (i < remainder ? 1 : 0);
            result.add(new ArrayList<>(listPhrases.subList(startIndex, endIndex)));
            startIndex = endIndex;
        }

        return result;
    }

    public String read(String path) {
        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text += line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }



}
