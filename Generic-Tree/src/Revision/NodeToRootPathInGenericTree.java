import java.util.*;
public class NodeToRootPathInGenericTree {
	
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
	
	//Time Complexity  : O(n) //Maximum will will tour each node 
	//Space Complexity : O(logN) //Height of the given Tree
	public static List<Integer> findNodeToRootPath(TreeNode root,int val,
		List<Integer> path){
		if(root.data==val) {
			path.add(root.data);
			return path;
		}
		for(TreeNode child:root.children){
			List<Integer> result=findNodeToRootPath(child,val,path);
			if(result.size()>0){
				path.add(root.data);
				return path;
			} 
		}
		return path;
	}
	
	public static void main(String[] args){
		int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,
		110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		TreeNode node=construct(arr);
		display(node);
		List<Integer> path=new ArrayList<>();
		System.out.println("Find in a Generic Tree >> "+findNodeToRootPath(node,120,path));
	}
	
}