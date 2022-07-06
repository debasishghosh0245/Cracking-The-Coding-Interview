import java.io.*;
import java.util.*;
public class AllNodesDistanceKInBinaryTree {
    
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
        Integer[]arr = {50,25,12,null,null,37,30,null,null,40,null,null,
        75,62,60,null,null,70,null,null,87,null,null};
        int k=1;
        Node root = construct(arr);
        ArrayList<Integer> result=new ArrayList<Integer>();
        nodeToRootPath(root,62,k,result);
        System.out.println(result);
    }
    
   private static int nodeToRootPath(Node root,int val,int k,ArrayList<Integer> list) {
       if(root==null) return -1;
       if(root.data==val) {
           printKLevelDown(root,k-0,null,list);
           return 1;
       }
       int leftdistance=nodeToRootPath(root.left,val,k,list);
       if(leftdistance!=-1){
           printKLevelDown(root,k-leftdistance,root.left,list);
           return leftdistance+1;
       }
       int rightdistance=nodeToRootPath(root.right,val,k,list);
       if(rightdistance!=-1) {
           printKLevelDown(root,k-rightdistance,root.right,list);
           return rightdistance+1;
       }
       return -1;
   }
   
   private static void printKLevelDown(Node root,int k,Node blockerNode,
       ArrayList<Integer> list){
       if(k < 0 || root==null || root==blockerNode) return ;
       if(k==0) {
           list.add(root.data);
       }
       printKLevelDown(root.left,k-1,blockerNode,list);
       printKLevelDown(root.right,k-1,blockerNode,list);
   }
}