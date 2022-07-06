import java.util.*;
public class MaximumPathSumInBetweenTwoLeavesBinaryTree{
    
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
        Integer[] arr={100,2,10,null,null,4,null,null,3,6,null,null,5,null,null};
        Node root = construct(arr);
        NodeProp nodeprp=pathSumOfTwoLeaves(root);
        System.out.println("Maximum Path Sum >> "+Math.max(
        nodeprp.maxLeafToLeafPath,nodeprp.maxNodeToLeafPath));
    }
    
    public static class NodeProp {
        int maxLeafToLeafPath;
        int maxNodeToLeafPath;
    }
    
    public static NodeProp pathSumOfTwoLeaves(Node root) {
        NodeProp nodeprop=new NodeProp();
        if(root==null)  {
            return nodeprop;
        }
        if(root.left==null && root.right==null) {
            nodeprop.maxNodeToLeafPath=root.data;
            nodeprop.maxLeafToLeafPath=0;
            return nodeprop;
        }
        NodeProp left=pathSumOfTwoLeaves(root.left);  
        NodeProp right=pathSumOfTwoLeaves(root.right);

        nodeprop.maxNodeToLeafPath=Math.max(left.maxNodeToLeafPath
        ,right.maxNodeToLeafPath)+root.data;
        nodeprop.maxLeafToLeafPath=left.maxNodeToLeafPath+
        right.maxNodeToLeafPath+root.data;
        nodeprop.maxLeafToLeafPath=Math.max(Math.max(left.maxLeafToLeafPath,
        right.maxLeafToLeafPath),nodeprop.maxLeafToLeafPath);
        return  nodeprop;
    }
}