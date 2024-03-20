import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.buildDictionaryTree("diccionario.txt"); // Replace "diccionario.txt" with your file name
        BinaryTree<String, String> binaryTree = dictionary.getBinaryTree();
        List<Association<String, String>> sortedDictionary = binaryTree.inorderTraversal();
        for (Association<String, String> association : sortedDictionary) {
            System.out.println("(" + association.key + ", " + association.value + ")");
        }

        String translatedText = dictionary.translateText("The woman asked me to do my homework about my town.");
        System.out.println(translatedText);
    }
}

