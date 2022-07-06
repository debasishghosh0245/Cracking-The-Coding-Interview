import java.util.*;
public class SerializeandDeserializeBinaryTree_297{
    
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
        Integer[]arr = {50,25,12,null,null,37,null,null,
        75,67,null,null,87,null,null};
        Node root = construct(arr);
        //display(root);
        String str=serialize(root);
        System.out.println(str);
        String[] strarr=str.split(",");
        System.out.println(Arrays.toString(strarr));
        Node root2=deserialized(strarr);
        System.out.println("Deserialized");
        display(root2);
    }
    
    private static String serialize(Node root) {
        StringBuilder sb=new StringBuilder();
        if(root==null) {
            sb.append("null");
            return sb.toString();
        }
        sb.append(root.data);
        String serializedLeftNode=serialize(root.left);
        String serializedRightNode=serialize(root.right);
        sb.append(","+serializedLeftNode);
        sb.append(","+serializedRightNode);
        return sb.toString();
    }
    private static int idx=0;
    private static Node deserialized(String[] str) {
        if(idx>str.length) return null;
        if(str[idx].equals("null")) {
            idx++;
            return null;
        }
        Node node=new Node(Integer.parseInt(str[idx++]));
        node.left=deserialized(str);
        node.right=deserialized(str);
        return node; 
    }
}