import java.util.*;
public class BinaryTreeMaximumPathSum_124{
    
    private static int maxPathSum=Integer.MIN_VALUE;
    
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
        //Integer[] arr = {5,4,11,7,null,null,2,null,null,null,8,13,null,null,4,null,1,null,null};
        //Integer[] arr={1,2,null,null,3,null,null};
        Integer[] arr={2,-1,null,null,null};
        Node root = construct(arr);
        maxPathSumHelper(root);
        System.out.println("Has Path Sum >> "+maxPathSum);
    }
    
    public static int maxPathSumHelper(Node root) {
      if(root==null) return 0;
        int sum=0;
        int leftSum=maxPathSumHelper(root.left);
        int rightSum=maxPathSumHelper(root.right);
        sum=leftSum+rightSum+root.data;
        maxPathSum=Math.max(maxPathSum,root.data);
        maxPathSum=Math.max(sum,maxPathSum);
        maxPathSum=Math.max(leftSum+root.data,maxPathSum);
        maxPathSum=Math.max(rightSum+root.data,maxPathSum);
        return sum;
    }
}