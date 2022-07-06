import java.util.*;
public class FindInGenericTree {
	
	public static class TreeNode {
		int data;
		ArrayList<TreeNode> children=new ArrayList<>(); 
		TreeNode(){}
		TreeNode(int data){
			this.data=data;
		}
	}
	
	public static void display(TreeNode root) {
		System.out.print(root.data+" -> ");
		for(TreeNode child: root.children){
			System.out.print(child.data+" ");
		}
		System.out.println();
		for(TreeNode child : root.children){
			display(child);
		}
	}
	
	public static TreeNode construct(int[] arr){
		Stack<TreeNode> stack=new Stack<>();
		TreeNode root=new TreeNode(arr[0]);
		stack.push(root);
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==-1){
				if(!stack.isEmpty()){
					stack.pop();
				}
			}
			else {
				TreeNode node=stack.peek();
				TreeNode newNode=new TreeNode(arr[i]);
				node.children.add(newNode);
				stack.push(newNode);
			}
		}
		return root;
	}
	
	//Time Complexity : O(n)
	//Space Complexity :O(logn)
	public static boolean find(TreeNode root,int val){
		if(root.data==val) return true;
		for(TreeNode child:root.children){
			boolean result=find(child,val);
			if(result) return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,
		110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		TreeNode node=construct(arr);
		display(node);
		System.out.println("Find in a Generic Tree >> "+find(node,150));
	}
	
}