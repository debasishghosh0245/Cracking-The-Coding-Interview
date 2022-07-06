import java.util.*;
public class LcaOfBst{
    
    static int idx=0;
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

    public static Node construct(Integer[] arr) {
        if(idx > arr.length || arr[idx]==null ) {
            idx++;
            return null;
        }
        Node node=new Node(arr[idx++],null,null);
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
        Integer[] arr={50,25,12,null,null,37,30,null,null,40,null,null,
        75,67,60,null,null,70,null,null,87,null,null}; 
        /* Integer[] arr={3,5,6,null,null,2,7,null,null,4,null,null,1,0,null,null,
        8,null,null}; */
        /* Integer[] arr={1,2,null,null,null}; */
        Node root = construct(arr);
        display(root);
        System.out.println("Print LCA "+ findLCA(root,60,70).data);
    }

    private static Node findLCA(Node root,int val1, int val2){
        if(root==null) return null;
        if(val1 < root.data && val2 < root.data) {
             return findLCA(root.left,val1,val2);
        }else if(val1 > root.data && val2 > root.data) {
             return findLCA(root.right,val1,val2);
        }else{
             return root;
        }
    }
}