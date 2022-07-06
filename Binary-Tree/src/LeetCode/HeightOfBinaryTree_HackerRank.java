package LeetCode;

public class HeightOfBinaryTree_HackerRank {

    public static void main(String[] args) {
        /** Root node 0th order traversal */
        BinaryTree btree = new BinaryTree();
        btree.root = new Node(1);
        /** 1th order traversal */
        btree.root.left = new Node(2);
        btree.root.right = new Node(3);
        /** 2nd order traversal */
        btree.root.left.left = new Node(4);
        btree.root.left.right = new Node(5);
        /** 3rd order traversal */
        btree.root.right.left = new Node(6);
        btree.root.right.right = new Node(7);

        System.out.println("Maximum Height of  a Binay Tree ");
        System.out.println(height(btree.root));
    }

    public static int height(Node root) {
        if(root==null)  return  -1;
        int left=height(root.left);
        int right=height(root.right);
        return 1+Math.max(left, right);
    }

}
