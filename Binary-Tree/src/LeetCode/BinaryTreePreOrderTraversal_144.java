package LeetCode;

import java.util.*;

public class BinaryTreePreOrderTraversal_144 {

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

        preorderTraversalRecursive(bindaryTree.root);
        System.out.println(" ");
        preorderTraversalIterative(bindaryTree.root);
    }

    public static void preorderTraversalRecursive(Node node) {
        if (node == null)  return;
        System.out.print(node.key + "  ");
        preorderTraversalRecursive(node.left);
        preorderTraversalRecursive(node.right);
    }

    public static void preorderTraversalIterative(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.print(current.key + "  ");
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
    }
}
