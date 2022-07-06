import java.util.*;
public class BinarySearchTreeConstructor {

	private static class Node{
		int data;
		Node left;
        Node right;
		Node(int data,Node left,Node right){
			this.data=data;
            this.left=left;
            this.right=right;
		}
	}
	
	 public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "-" : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "-" : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
	
	public static void main(String[] args){
		int[] arr={12,25,30,37,40,50,60,67,70,75,87};
		Node root=null;
		root=construct(root,arr,0,arr.length-1);
		display(root);
	}
	
	public static Node construct(Node root,int[] arr,int low,int high) {
		if(high < low) return null;
        int mid=low+(high-low)/2;
        int data=arr[mid];
        Node left=construct(root,arr,low,mid-1);
        Node right=construct(root,arr,mid+1,high);
        Node node=new Node(data,left,right);
        return node;
	}

}
