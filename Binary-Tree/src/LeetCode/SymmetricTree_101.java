import java.util.*;

public class SymmetricTree_101 {

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
        //Integer[] arr={1,2,3,null,null,4,null,null,2,4,null,null,3,null,null};
        Integer[] arr={1,2,null,3,null,null,2,null,3,null,null};
        Node root = construct(arr);
        display(root);
        System.out.println(ismirror(root,root));
    }
    
    public static Node mirror(Node root) {
    if(root==null) return null;
        Node left=null;
        Node right=null;
        if(root.left!=null) {
            left=mirror(root.left); 
        }
        if(root.right!=null) {
            right=mirror(root.right); 
        }
        root.left=right;
        root.right=left;
        return root;
    }
    
    public static boolean isSymmetric(Node root1,Node root2) {
        
        if(root1==null && root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root2==null && root1!=null) return false;
        if(root1.data!=root2.data) {
            return false;
        }
        boolean issymmetric=isSymmetric(root1.left,root2.right);
        if(!issymmetric) return false;
        issymmetric=isSymmetric(root1.right,root2.left);
        if(!issymmetric) return false;
        return true;
    }
    
    //Same Code But in Cool Way
    public static boolean ismirror(Node root1,Node root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        return (root1.data==root2.data) 
             && ismirror(root1.left,root2.right)
             && ismirror(root1.right,root2.left);
    }
    
}