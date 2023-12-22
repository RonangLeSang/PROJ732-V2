import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Coordinator {

    String text = "";

    public String read(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (line != null) {
                text += "\n" + line;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }



}
