import java.util.*;
public class PathSum_112{
       
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
            }  else if (top.state == 2) {
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
        Integer[] arr = {5,4,11,7,null,null,2,null,null,null,8,13,null,null,4,null,1,null,null};
        //Integer[] arr={1,2,null,null,3,null,null};
        //Integer[] arr={1,null,null};
        Node root = construct(arr);
        System.out.println("Has Path Sum >> "+hasPathSumHelper(root,22,root.data));
    }
    public static boolean hasPathSumHelper(Node root,int targetSum,int sumsf) {  
        if(root==null) return false;
        //this is for root to complete leaf path //
        if(root.left==null && root.right==null) {
            if(targetSum==sumsf) return true; 
        }
        if(root.left!=null) {
            boolean leftresult=hasPathSumHelper(root.left,targetSum,
            sumsf+root.left.data);
            if(leftresult) return true;
        }
        if(root.right!=null) {
            boolean rightresult=hasPathSumHelper(root.right,targetSum,
            sumsf+root.right.data);
            if(rightresult) return true;
        }
        return false;
    }
}