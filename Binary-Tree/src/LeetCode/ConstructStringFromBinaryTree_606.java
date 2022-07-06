import java.util.*;
public class ConstructStringFromBinaryTree_606{
    
    private static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
       }
    }
    private static Node construct(Integer[] arr) {
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

    private static void display(Node node) {
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
        Integer[]arr = {1,2,4,null,null,null,3,null,null};
        Node root = construct(arr);
        display(root);
        StringBuilder sb=new StringBuilder();
        String str=serialize(root,sb.append(root.data));
        System.out.println(str.substring(0,str.length()-1));
    }
    
    private static String serialize(Node root,StringBuilder sb) {
        if(root==null){
          return "";  
        } 
        if(root.left==null) {
            sb.append("()");
        }
        if(null!=root.left) {
            serialize(root.left,sb.append("("+root.left.data)); 
        }
        if(null!=root.right) {
            serialize(root.right,sb.append("("+root.right.data));
        }
        sb.append(")");
        return sb.toString();
    }
}