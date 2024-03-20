import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BinaryTreeTest {

    @Test
    public void testInsertionAndInorderTraversal() {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        
        // Insertar elementos en el árbol
        tree.insert(new Association<>(5, "apple"));
        tree.insert(new Association<>(3, "banana"));
        tree.insert(new Association<>(7, "orange"));
        tree.insert(new Association<>(2, "grape"));
        tree.insert(new Association<>(4, "peach"));
        tree.insert(new Association<>(6, "lemon"));
        tree.insert(new Association<>(8, "pear"));
        
        // Realizar recorrido inorder
        List<Association<Integer, String>> inorderList = tree.inorderTraversal();
        
        // Verificar el tamaño del recorrido inorder
        Assertions.assertEquals(7, inorderList.size());
        
        // Verificar el orden correcto del recorrido inorder
        Assertions.assertEquals(2, inorderList.get(0).getKey());
        Assertions.assertEquals(3, inorderList.get(1).getKey());
        Assertions.assertEquals(4, inorderList.get(2).getKey());
        Assertions.assertEquals(5, inorderList.get(3).getKey());
        Assertions.assertEquals(6, inorderList.get(4).getKey());
        Assertions.assertEquals(7, inorderList.get(5).getKey());
        Assertions.assertEquals(8, inorderList.get(6).getKey());
    }
}
