import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Coordinator {

    String text = "";

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
