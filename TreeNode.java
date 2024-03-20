class TreeNode<K extends Comparable<K>, V> {
    Association<K, V> association;
    TreeNode<K, V> left, right;

    public TreeNode(Association<K, V> association) {
        this.association = association;
        this.left = this.right = null;
    }
}