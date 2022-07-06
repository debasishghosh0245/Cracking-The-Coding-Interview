import java.util.*;
public class ConstructBSTFromInOrderTraversal {
    
    private static class Node {
         int data;
         Node left;
         Node right;
         Node(int data,Node left,Node right) {
             this.data=data;
             this.left=left;
             this.right=right;
         }
    }
    
    public static void display(Node root) {
        if(root==null) return;
        System.out.print(root.left!=null ? root.left.data+" ": "");
        System.out.print(root.data+" ");
        System.out.print(root.right!=null ? root.right.data+" " : " ");
        System.out.println("");
        display(root.left);
        display(root.right);
    }
    
    public static Node construct(int[] arr,int left,int right){
        if(right < left) return null;
        int mid=left+(right-left)/2;
        int data=arr[mid];
        Node root=new Node(data,null,null);
        root.left=construct(arr,left,mid-1);
        root.right=construct(arr,mid+1,right);
        return root;
    }
    
    public static void main(String[] args) {
        int[] arr={12,25,30,37,40,60,67,70,75,87};
        Node root=construct(arr,0,arr.length-1);
        display(root);
    }
}