import java.io.*;
import java.util.*;
public class RecoverBst {
    
    private static Node x=null;
    private static Node y=null;
    private static Node prev=null;
    
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
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) throws Exception {
        Integer[]arr = {55,25,12,null,null,75,30,null,null,40,null,null,
        37,67,60,null,null,70,null,null,87,null,null}; 
        Node root = construct(arr);
        display(root);
        recoverTree(root);
        System.out.println("After Recover Display");
        display(root);
        
    }
    
    public static void recoverTree(Node root) {
        findSwapNode(root);
        swapNodes(x,y);
    }

    public static void findSwapNode(Node root) {
        if(root==null) return;
        findSwapNode(root.left);
        //for inconsistency 
        if(null!=prev && prev.data > root.data) {
            x=prev;
            y=root;
        }else{
            prev=root;
        }
        findSwapNode(root.right);
    }
   
    public static void swapNodes(Node x, Node y) {
        int temp=x.data;
        x.data=y.data;
        y.data=temp;
    }
}