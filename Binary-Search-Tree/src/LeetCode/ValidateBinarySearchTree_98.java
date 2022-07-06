import java.util.*;

public class ValidateBinarySearchTree_98 {

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
        
        //Integer[] arr={5,1,null,null,7,6,null,null,8,null,null};
        //Integer[] arr={2,10,null,null,3,null,null};
        //Integer[] arr={5,1,null,null,4,3,null,null,6,null,null};
        //Integer[] arr={2,2,null,null,2,null,null};
        Integer[] arr={2147483647,null,null};
        Node root = construct(arr);
        BSTProp bstprop=isBinarySearchTree(root);
        System.out.println("Validate Binary Search Tree >> "+bstprop.isbst);
    }
    
    protected static class BSTProp {
        long max;
        long min;
        boolean isbst;
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
        }else{
            bstprop.isbst=false;
        }
        return bstprop;
    }
}