import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        
        while (option != 3) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Ver diccionario");
            System.out.println("2. Traducir texto");
            System.out.println("3. Salir");
            option = scanner.nextInt();
            
            switch(option){
                case 1: // Diccionario
                    dictionary.buildDictionaryTree("diccionario.txt");
                    BinaryTree<String, String> binaryTree = dictionary.getBinaryTree();
                    List<Association<String, String>> sortedDictionary = binaryTree.inorderTraversal();
                
                    for (Association<String, String> association : sortedDictionary) {
                        System.out.println("(" + association.key + ", " + association.value + ")");
                    }
                    break;
                case 2: // Texto a traducir
                    String text = Lector.readTextFromFile("texto.txt");
                    String translatedText = dictionary.translateText(text);
                    System.out.println("Texto traducido:");
                    System.out.println(translatedText);
                    break;
                case 3: // Salir
                    System.out.println("A D I O S");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona nuevamente.");
                    break;
            }
        }
    }
}
