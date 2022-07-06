import java.io.*;
import java.util.*;
public class HouseRobberIII_337 {
    
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
        
        Integer[] arr={3,2,null,3,null,null,3,null,1,null,null};
        
        //Integer[]arr = {3,4,1,null,null,3,null,null,5,null,1,null,null};
        //Integer[]arr = {2,7,2,null,null,6,5,null,null,11,null,null,5,null,8,4,null,null,null};
        Node root = construct(arr);
        display(root);
        NodeProp prop=houseRobber(root);
        System.out.println("Maximum Robbery >> "+Math.max(prop.include,prop.exclude));
    }
    
    private static class NodeProp {
        int include;
        int exclude;
        NodeProp(){}
        NodeProp(int include,int exclude) {
            this.include=include;
            this.exclude=exclude;
        }
    }
    
    public static NodeProp houseRobber(Node root) {
        if(root==null) {
            NodeProp nodeprop=new NodeProp(0,0);
            return nodeprop;
        } 
        NodeProp left=houseRobber(root.left);
        NodeProp right=houseRobber(root.right);
        NodeProp nodeprop=new NodeProp();
        nodeprop.include=root.data+left.exclude+right.exclude;
        nodeprop.exclude=Math.max(left.exclude,left.include)+Math.max(right.include,right.exclude);   
        return nodeprop;
   }
}