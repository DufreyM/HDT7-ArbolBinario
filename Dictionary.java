import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Dictionary {
    private BinaryTree<String, String> dictionary;

    public Dictionary() {
        dictionary = new BinaryTree<>();
    }

    public void buildDictionaryTree(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] pair = line.split(",");
                    String key = pair[0].trim().substring(1);
                    String value = pair[1].trim().substring(0, pair[1].length()-2);
                    dictionary.insert(new Association<>(key.toLowerCase(), value.toLowerCase()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String translateText(String text) {
        StringBuilder translatedText = new StringBuilder();
        String[] words = text.split("\\s+");
        for (String word : words) {
            String translatedWord = translateWord(word.toLowerCase());
            translatedText.append(translatedWord).append(" ");
        }
        return translatedText.toString();
    }

    private String translateWord(String word) {
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

    public BinaryTree<String, String> getBinaryTree() {
        return dictionary;
    }

}
