import java.util.*;
public class PredecessorAndSuccessorOfAnElement {
	
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
	
	//Time Complexity  : O(n)
	//Space Complexity : O(logn)
	public static TreeNode predecessor;
	public static TreeNode successor;
	public static int state=0;
	public static void predecessorAndSuccessor(TreeNode root, int val){
		if(state==1){
			successor=root;
			state++;
		}
		else if(state==0 && val==root.data){
			state=1;
		}
		else if(state==0 && val!=root.data){
			predecessor=root;
		}
		for(TreeNode child: root.children){
			predecessorAndSuccessor(child,val);
		}
	}
	
	public static void main(String[] args){
		int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,
		110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		TreeNode node=construct(arr);
		display(node);
		predecessorAndSuccessor(node,120);
		System.out.println("Predecessor >> "+predecessor.data);
		System.out.println("Successor >> "+successor.data);
	}
}