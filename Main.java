import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        
            dictionary.buildDictionaryTree("diccionario.txt");
            BinaryTree<String, String> binaryTree = dictionary.getBinaryTree();
            List<Association<String, String>> sortedDictionary = binaryTree.inorderTraversal();
        
            for (Association<String, String> association : sortedDictionary) {
                System.out.println("(" + association.key + ", " + association.value + ")");
            }
            //Texto a traducir
            String text = Lector.readTextFromFile("texto.txt");
            String translatedText = dictionary.translateText(text);
            System.out.println("Texto traducido:");
            System.out.println(translatedText);
        } 
    }
