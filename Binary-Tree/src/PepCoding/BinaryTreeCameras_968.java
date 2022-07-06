import java.io.*;
import java.util.*;
public class BinaryTreeCameras_968 {
    
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
        Integer[] arr={1,1,1,null,null,1,null,null,null};
        Node root = construct(arr);
        display(root);
        if(minCameraCover(root)==-1) {
            minCameraCnt=1;
        }
        System.out.println("Min Camera Count >> "+minCameraCnt);
    }
    
    public static int minCameraCover(Node root) {
        if(root==null ) return 1;
        int leftNode=minCameraCover(root.left);
        int rightNode=minCameraCover(root.right);
        if(leftNode==-1 || rightNode==-1) {
            minCameraCnt+=1;
            return 0;
        }
        if(leftNode==0 || rightNode==0) {
            return 1;
        }
        return -1;
    }
}