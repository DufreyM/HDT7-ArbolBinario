import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DictionaryTest {

    @Test
    public void testBuildDictionaryTree() {
        Dictionary dictionary = new Dictionary();
        dictionary.buildDictionaryTree("dictionary.txt"); 

        BinaryTree<String, String> binaryTree = dictionary.getBinaryTree();

        Assertions.assertNotNull(binaryTree);

    }
}
