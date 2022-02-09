package LeetCode;

public class MaximumDepthOfBinaryTree_104 {
    public static void main(String[] args) {
        BinaryTree btree = new BinaryTree();
        // level 0
        btree.root = new Node(1);
        // level 1
        btree.root.left = new Node(2);
        btree.root.right = new Node(3);
        // level 2
        btree.root.left.left = new Node(4);
        btree.root.left.right = new Node(5);
        btree.root.right.left = new Node(6);
        btree.root.right.right = new Node(7);
        btree.root.right.left.left = new Node(8);
        System.out.println("Maximum Depth  " + maxDepth(btree.root));
    }

    public static int maxDepth(Node root) {
        if (root == null) return 0;
        int x = maxDepth(root.left);
        int y = maxDepth(root.right);
        return 1 + Math.max(x, y);
    }
}