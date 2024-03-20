import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class DictionaryTest {

    @Test
    public void testBuildDictionaryTree() {
        Dictionary dictionary = new Dictionary();
        dictionary.buildDictionaryTree("dictionary.txt"); 

        BinaryTree<String, String> binaryTree = dictionary.getBinaryTree();
        // Verificar que el diccionario se haya construido correctamente
        Assertions.assertNotNull(binaryTree);
        // Puedes agregar más aserciones para verificar la estructura y los contenidos del árbol si es necesario
    }
}
