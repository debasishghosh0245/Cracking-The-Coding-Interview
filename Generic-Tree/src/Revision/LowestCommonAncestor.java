import java.util.*;
public class LowestCommonAncestor {
	
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
	
	//Time Complexity :
	//Space Complexity :
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
	
	//Time Complexity: O(n)
	//Space Complexity: O(logn)
	public static int findLCA(TreeNode root,int val1,int val2){
		List<Integer> path1=findNodeToRootPath(root,val1,new ArrayList<Integer>());
		List<Integer> path2=findNodeToRootPath(root,val2,new ArrayList<Integer>());
		System.out.println("Path1 >> "+path1);
		System.out.println("Path2 >> "+path2);
		
		int i=path1.size()-1;
		int j=path2.size()-1;
		
		while(i>=0 && j>=0 
			&& path1.get(i)==path2.get(j)){
			i--;
			j--;
		}
		return path2.get(j+1);
	}
	
	public static void main(String[] args){
		int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,
		110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		TreeNode node=construct(arr);
		display(node);
		List<Integer> path=new ArrayList<>();
		System.out.println("Find in a Generic Tree >> "+findLCA(node,120,70));
	}
	
}