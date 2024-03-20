import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
public class Dictionary {
    public static void main(String[] args) {
        BinaryTree<String, String> dictionary = buildDictionaryTree("diccionario.txt");
        List<Association<String, String>> sortedDictionary = dictionary.inorderTraversal();
        for (Association<String, String> association : sortedDictionary) {
            System.out.println("(" + association.key + ", " + association.value + ")");
        }

        translateText(dictionary, "The woman asked me to do my homework about my town.");
    }

    public static BinaryTree<String, String> buildDictionaryTree(String fileName) {
        BinaryTree<String, String> dictionary = new BinaryTree<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] pair = line.split(",");
                    String key = pair[0].trim().substring(1);
                    String value = pair[1].trim().substring(0, pair[1].length() - 1);
                    dictionary.insert(new Association<>(key.toLowerCase(), value.toLowerCase()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    public static void translateText(BinaryTree<String, String> dictionary, String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            String translatedWord = translateWord(dictionary, word.toLowerCase());
            System.out.print(translatedWord + " ");
        }
    }

    public static String translateWord(BinaryTree<String, String> dictionary, String word) {
        TreeNode<String, String> root = dictionary.root;
        while (root != null) {
            int compareResult = word.compareTo(root.association.key);
            if (compareResult == 0) {
                return root.association.value;
            } else if (compareResult < 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return "*" + word + "*";
    }
}