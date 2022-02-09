package LeetCode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_102 {
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
    }

    public static List<List<Integer>> levelOrder(Node root) {
        return null;
    }
}