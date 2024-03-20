import java.util.ArrayList;
import java.util.List;

public class BinaryTree<K extends Comparable<K>, V> {
    TreeNode<K, V> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(Association<K, V> association) {
        root = insertRec(root, association);
    }

    private TreeNode<K, V> insertRec(TreeNode<K, V> root, Association<K, V> association) {
        if (root == null) {
            root = new TreeNode<>(association);
            return root;
        }

        if (association.key.compareTo(root.association.key) < 0)
            root.left = insertRec(root.left, association);
        else if (association.key.compareTo(root.association.key) > 0)
            root.right = insertRec(root.right, association);

        return root;
    }

    public List<Association<K, V>> inorderTraversal() {
        List<Association<K, V>> result = new ArrayList<>();
        inorderTraversalRec(root, result);
        return result;
    }

    private void inorderTraversalRec(TreeNode<K, V> root, List<Association<K, V>> result) {
        if (root != null) {
            inorderTraversalRec(root.left, result);
            result.add(root.association);
            inorderTraversalRec(root.right, result);
        }
    }
}