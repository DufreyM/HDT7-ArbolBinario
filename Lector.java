import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lector {

    public static String readTextFromFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
