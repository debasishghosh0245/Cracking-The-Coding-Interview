import java.util.*;
public class BinaryTreeConstructor{
	
	public static class Node{
		Node left;
		Node right;
		int data;
		
		Node(int data){
			this.data=data;
		}
		
		Node(int data,Node left,Node right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}

	static int idx=0;
	
	public static Node construct(Node root,int[] arr){
		if(idx >=arr.length) return null;
		if(arr[idx]==-1) {
			idx++;
			return null;
		}
		Node node=new Node(arr[idx++]);
		node.left=construct(root,arr);
		node.right=construct(root,arr);
		return node;
	}

	public static void display(Node root){
		if(root==null) return;
		System.out.print(""+root.data+" ");
		display(root.left);
		display(root.right);
	}
	
	
	public static void main(String[] args){
		
		int[] arr={50,25,12,-1,-1,37,30,-1,-1,-1,75,62,-1,70,-1,-1,87,-1,-1};
		Node root=new Node(arr[0]);
		BinaryTreeConstructor binaryTree=new BinaryTreeConstructor();
		Node node=binaryTree.construct(root,arr);
		display(node);
	}
}