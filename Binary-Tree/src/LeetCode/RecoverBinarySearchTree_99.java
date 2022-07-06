import java.io.*;
import java.util.*;
public class RecoverBinarySearchTree_99 {
    
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
        Integer[]arr = {55,25,12,null,null,37,30,null,null,40,null,null,
        75,67,60,null,null,70,null,null,87,null,null}; */
        //Integer[] arr={2,2,2,null,null,null,null};
        Node root = construct(arr);
        display(root);
        System.out.println(validate(root));
        //System.out.println(validateBST(root).isValid);
    }
    
    private static class BSTProp {
        private int max;
        private int min;
        private boolean isValid;
    }
    
    public static BSTProp validateBST(Node root){
       if(root==null){
            BSTProp bstProp=new BSTProp();
            bstProp.max=Integer.MIN_VALUE;
            bstProp.min=Integer.MAX_VALUE;
            bstProp.isValid=true;
            return bstProp;
       }
       BSTProp left=validateBST(root.left);
       BSTProp right=validateBST(root.right);
       BSTProp bstProp=new BSTProp();
       bstProp.min=Math.min(root.data,Math.min(left.min,right.min));
       bstProp.max=Math.max(root.data,Math.max(right.max,left.max));
       if(left.isValid && left.max < root.data &&
       right.isValid && right.min > root.data) {
           bstProp.isValid=true;
       }else{
           bstProp.isValid=false;
       } 
       return bstProp;
    }
    
    private static int prev=Integer.MIN_VALUE;
    public static boolean validate(Node root){
        if(root==null) return true;
        if(!validate(root.left)) {
            return false;
        }
        if(prev >= root.data) {
            return false;
        }else{
            prev=root.data;
        }
        if(!validate(root.right)){
             return false;
        }
        return true;
    }
}