package LeetCode;

import java.util.*;

class BinaryTreeInorderTraversal_94 {

    static class BinaryTree {
        Node root;
    }

    public static void main(String[] args) {

        BinaryTree bindaryTree = new BinaryTree();
        /** Root Level */
        bindaryTree.root = new Node(1);
        /** 1st Level */
        bindaryTree.root.left = new Node(2);
        bindaryTree.root.right = new Node(3);
        /** 2nd Level */
        bindaryTree.root.left.left = new Node(4);
        bindaryTree.root.left.right = new Node(5);

        bindaryTree.root.right.left = new Node(6);
        bindaryTree.root.right.right = new Node(7);
        inorderRecursive(bindaryTree.root);
        System.out.println(" ");
        inorderTraversalIterative(bindaryTree.root);

    }

    public static void inorderRecursive(Node node) {
        if (null == node)  return;
        inorderRecursive(node.left);
        System.out.print(node.key + "  ");
        inorderRecursive(node.right);
    }

    public static void inorderTraversalIterative(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.key + "  ");
            current = current.right;
        }
    }
}
