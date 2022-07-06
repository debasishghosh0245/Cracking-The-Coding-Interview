import java.io.*;
import java.util.*;
public class InorderSuccessorBST_285 {

    public static class Node {
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
        Integer[] arr={50,25,12,null,null,37,30,null,null, 
        null,75,67,null,70,null,null,87,null,null};
        Node root=construct(arr);
        inorderSuccessorApproach2(root,67);
        System.out.println("successor "+successor.data);
    }
    
    // Approach 1 : Inorder Traversl //
    public static void inorderSuccessor(Node root,int data) {
        List<Node> list=inorder(root,new ArrayList<Node>());
        for(int i=0;i<list.size();i++){
            if(list.get(i).data==data){
                System.out.println("Inorder Successor >> "+list.get(i+1).data);
            }
        }
    }
    public static List<Node> inorder(Node root,List<Node> list) {
        if(root==null) return list;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
        return list;
    }
    
    // Approach 1 : End //
    private static Node successor=null;
    
    public static void inorderSuccessorApproach2(Node root,int target){
       if(root==null) return;
       if(target >= root.data) {
           //smaller element is here only we are calling 
           //larget element from here only 
           inorderSuccessorApproach2(root.right,target);
       }
       if(target < root.data){
           //larget element is here only
           // we are calling for smaller element 
           successor=root;  
           inorderSuccessorApproach2(root.left,target);
       }
    }
}