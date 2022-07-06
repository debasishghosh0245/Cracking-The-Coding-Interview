import java.util.*;
public class GenericTreeTraversals{
	
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
	
	public static void traversal(TreeNode root){
		System.out.println("Node Pre "+root.data);
		for(TreeNode child: root.children){
			System.out.println("Edge Pre "+root.data+"--"+child.data);
			traversal(child);
			System.out.println("Edge Post "+root.data+"--"+child.data);
			
		}
		System.out.println("Node Post "+root.data);
	}

	public static void main(String[] args){
		int[] arr={10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
		TreeNode node=construct(arr);
		traversal(node);			
	}
	
}