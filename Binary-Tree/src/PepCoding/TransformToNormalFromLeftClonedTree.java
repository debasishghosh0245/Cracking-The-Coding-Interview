import java.io.*;
import java.util.*;
public class TransformToNormalFromLeftClonedTree {
    
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
       }
    }
    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
                top.node.left = new Node(arr[idx], null, null);
                Pair lp = new Pair(top.node.left, 1);
            st.push(lp);
            } else {
                top.node.left = null;
            }
            top.state++;
        } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
                top.node.right = new Node(arr[idx], null, null);
                Pair rp = new Pair(top.node.right, 1);
                st.push(rp);
            } else {
                top.node.right = null;
            }
            top.state++;
        } else {
            st.pop();
        }
    }
        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "-" : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "-" : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) throws Exception {
        Integer[] arr={50,50,25,25,12,12,null,null,null,null,37,37,30,30,null,null,null,null,null,null,75,75,62,62,null,null,70,70,null,null,null,null,87,87,null,null,null};
        Node root = construct(arr);
        root=transFromBackLeftClonedTree(root);
        display(root);
    }
    
    public static Node transFromBackLeftClonedTree(Node root){
        if(root==null){
           return null; 
        } 
        Node lefttransformedNode=null;
        Node righttransformedNode=null;
        if(null!=root.left) {
             lefttransformedNode=transFromBackLeftClonedTree(root.left.left);
        }
        if(null!=root.right) {
             righttransformedNode=transFromBackLeftClonedTree(root.right);
        }
        root.left=lefttransformedNode;
        root.right=righttransformedNode;
        return root;
    }
}