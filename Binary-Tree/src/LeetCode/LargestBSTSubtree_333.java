import java.util.*;

public class LargestBSTSubtree_333 {

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
        str += node.left == null ? "null" : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "null" : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) throws Exception {
        
        Integer[] arr={50,25,12,null,null,37,30,null,null,
        40,null,null,10,62,60,null,null,70,null,null,87,null,null};
        
        Node root = construct(arr);
        display(root);
        BSTProp bstprop=isBinarySearchTree(root);
        System.out.println("Root of the Larget Binary Search Tree   >> "+bstprop.root.data);
        System.out.println("Size of Larget Binary Search Tree >> "+bstprop.size);
    }
    
    protected static class BSTProp {
        long max;
        long min;
        boolean isbst;
        Node root;
        int size;
    }
    
    public static BSTProp isBinarySearchTree(Node root){
        if(root==null) { 
            BSTProp bstprop=new BSTProp();
            bstprop.min=Long.MAX_VALUE;
            bstprop.max=Long.MIN_VALUE;
            bstprop.isbst=true;
            return bstprop;
        }        
        BSTProp leftbst=isBinarySearchTree(root.left);
        BSTProp rightbst=isBinarySearchTree(root.right);
        BSTProp bstprop=new BSTProp();
        bstprop.max=Math.max(root.data,Math.max(leftbst.max,rightbst.max));
        bstprop.min=Math.min(root.data,Math.min(rightbst.min,leftbst.min));
        if(leftbst.isbst && rightbst.isbst && 
            root.data > leftbst.max && root.data < rightbst.min ){
            bstprop.isbst=true;
            bstprop.root=root;
            bstprop.size=leftbst.size+rightbst.size+1;
        }else{
            if(leftbst.size>rightbst.size) {
               bstprop.root=leftbst.root;
               bstprop.size=leftbst.size; 
            }
            else{
                bstprop.root=rightbst.root;
                bstprop.size=rightbst.size; 
            }
            bstprop.isbst=false;
        }
        return bstprop;
    }
}