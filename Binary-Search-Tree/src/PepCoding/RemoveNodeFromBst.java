import java.io.*;
import java.util.*;
public class RemoveNodeFromBst {
    
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

    public static int max(Node root) {
        if(root==null) return Integer.MIN_VALUE;
        int left=max(root.left);
        int right=max(root.right);
        int max=Math.max(left,right);
        max=Math.max(max,root.data);
        return max;
    }

    public static void main(String[] args) throws Exception {
        Integer[] arr={50,25,12,null,null,37,30,null,null, 
        null,75,62,null,70,null,null,87,null,null};
        Node root = construct(arr);
        //display(root);
        deleteNode(root,50);
        System.out.println("Remove -------------");
        display(root);
    }
    
    public static Node deleteNode(Node root, int key) {
        if(root==null) return null;
        if(key < root.data) {
             root.left=deleteNode(root.left,key);  
        }
        else if(key > root.data) {
             root.right=deleteNode(root.right,key); 
        }
        else {
            if(root.left!=null && root.right!=null) {
                int lm=max(root.left);
                deleteNode(root,lm);
                root.data=lm;
                return root;
            } 
            else if(root.left!=null) {
                 return root.left;
            }
            else if(root.right!=null) {
                 return root.right; 
            }
            else {
                return null;
            }
        }
        return root;
    }
}