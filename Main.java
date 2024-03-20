import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        //DICCIONARIO
        dictionary.buildDictionaryTree("diccionario.txt");
        BinaryTree<String, String> binaryTree = dictionary.getBinaryTree();
        List<Association<String, String>> sortedDictionary = binaryTree.inorderTraversal();
        
        for (Association<String, String> association : sortedDictionary) {
            System.out.println("(" + association.key + ", " + association.value + ")");
        }
        //Texto a traducir
        String text = readTextFromFile("texto.txt");
        
        String translatedText = dictionary.translateText(text);
        
        System.out.println("Texto traducido:");
        System.out.println(translatedText);
    }
    
    private static String readTextFromFile(String fileName) {
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
