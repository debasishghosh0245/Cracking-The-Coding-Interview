package LeetCode;

import java.util.*;

public class BinaryTreePostorderTraversal_145 {
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
        postorderTraversalRecursion(bindaryTree.root);
        System.out.println(" ");
        postorderTraversalIterative(bindaryTree.root);
    }

    public static void postorderTraversalRecursion(Node node) {
        if (null == node)
            return;
        postorderTraversalRecursion(node.left);
        postorderTraversalRecursion(node.right);
        System.out.print(node.key + "  ");
    }

    public static void postorderTraversalIterative(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (null != current || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            Node temp = stack.peek().right;
            if (temp == null) {
                temp = stack.pop();
                System.out.print(temp.key + "  ");
                while (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    System.out.print(temp.key + "  ");
                }
            } else {
                current = temp;
            }
        }
    }
}
