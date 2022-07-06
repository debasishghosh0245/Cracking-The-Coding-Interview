public class BinaryTree {

    Node root;

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        postOrder(binaryTree.root);
    }

    void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    public static void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (null == node)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
    }
}
