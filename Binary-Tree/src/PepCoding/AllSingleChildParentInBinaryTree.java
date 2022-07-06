import java.io.*;
import java.util.*;
public class AllSingleChildParentInBinaryTree {
    
    private static int idx=0; 
    private static int minCameraCnt=0;
    
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
       if(idx > arr.length) return null;
       if(arr[idx]==null){
           idx++;
           return null;
       } 
       Node node=new Node(arr[idx++]);
       node.left=construct(arr);
       node.right=construct(arr);
       return node;
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
        //Integer[] arr={4,2,1,12,null,null,null,3,13,null,null,null,
        //6,5,10,null,null,null,7,14,null,null,null}; 
        Integer[] arr={3,1,null,null,null};
        Node root = construct(arr);
        //display(root);
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println(printSingleChild(root,null,list));
    }
    
    public static ArrayList<Integer> printSingleChild(Node node,
        Node parent, ArrayList<Integer> list) {
        if(node==null) return list;
        if(parent!=null && parent.left!=null && parent.right==null){
            list.add(parent.data);
        }
        if(parent!=null && parent.left==null && parent.right!=null){
            list.add(parent.data);
        }
        printSingleChild(node.left,node,list);
        printSingleChild(node.right,node,list);
        return list;
    }
}