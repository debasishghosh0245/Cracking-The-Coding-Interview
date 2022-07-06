import java.io.*;
import java.util.*;
public class LongestZigzagPathInABinaryTree {
    
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
        //Integer[] arr={3,2,null,3,null,null,3,null,1,null,null};
        //Integer[] arr={1,null,null};
        Integer[] arr={1,null,2,3,null,null,4,5,
        null,5,null,7,null,null,8,null,null};
        Node root = construct(arr);
        display(root);
        NodeProp nodeprop=longestZigZag(root);
        System.out.println("Longest Zig Zag Path >> "+nodeprop.maxDistance);
    }
    
    private static class NodeProp{
        int leftEdgEndedPthDist=-1;
        int rightEdgEndedPthDist=-1;
        int maxDistance=0;
        NodeProp(){ }
        NodeProp(int leftEdgEndedPthDist,int rightEdgEndedPthDist,int maxDistance){
            this.leftEdgEndedPthDist=leftEdgEndedPthDist;
            this.rightEdgEndedPthDist=rightEdgEndedPthDist;
            this.maxDistance=maxDistance;
        }
    }
    //Time complexity >> O(2^n)
    //Space complexity >> O(n)
    public static NodeProp longestZigZag(Node root) {
        if(root==null) {
            NodeProp nodeprp=new NodeProp(-1,-1,0);
            return nodeprp;
        }
        NodeProp left=longestZigZag(root.left);
        NodeProp right=longestZigZag(root.right);
        NodeProp nodeprp=new NodeProp();
        nodeprp.leftEdgEndedPthDist=left.rightEdgEndedPthDist+1;
        nodeprp.rightEdgEndedPthDist=right.leftEdgEndedPthDist+1;
        int dist=Math.max(Math.max(left.rightEdgEndedPthDist,left.leftEdgEndedPthDist),
        Math.max(right.rightEdgEndedPthDist,right.leftEdgEndedPthDist));
        dist=Math.max(dist,Math.max(nodeprp.rightEdgEndedPthDist,nodeprp.leftEdgEndedPthDist));
        nodeprp.maxDistance=dist;
        return nodeprp;
   }
}