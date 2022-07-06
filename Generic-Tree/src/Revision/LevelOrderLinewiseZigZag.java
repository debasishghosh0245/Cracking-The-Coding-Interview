import java.util.*;
public class LevelOrderLinewiseZigZag {
	
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
	
	public static void levelOrderTraversal(TreeNode root) {
		LinkedList<TreeNode> queue=new LinkedList<>();
		queue.addFirst(root);
		int level=1;
		while(!queue.isEmpty()){
			int size=queue.size();
			for(int i=0;i<size;i++){
				if(level%2!=0){
					TreeNode node=queue.removeFirst();
					System.out.print(node.data+" ");
					if(node.children.size()>0){
						for(TreeNode child: node.children) {
							queue.addLast(child);
						}
					}
				}else{
					TreeNode node=queue.removeLast();
					System.out.print(node.data+" ");
					if(node.children.size()>0){
						for(int j=node.children.size()-1;j>=0;j--) {
							queue.addFirst(node.children.get(j));
						}
					}
				}
			}
			level++;
			System.out.println();
		}
	}
	
	public static void levelOrderTraversalI(TreeNode root){
		Stack<TreeNode> mainStack=new Stack<>();
		Queue<TreeNode> childQueue=new ArrayDeque<>();
		mainStack.add(root);
		int level=1;
		while(!mainStack.isEmpty()){
			TreeNode node=mainStack.pop();
			System.out.print(node.data+" ");
			if(level%2==0){
				if(node.children.size()>0){
					for(int j=node.children.size()-1;j>=0;j--){
					childQueue.add(node.children.get(j));
					}
				}
			}
			else{
				if(node.children.size()>0){
					for(TreeNode child: node.children){
						childQueue.add(child);
					}
				}
			}
			if(mainStack.isEmpty()){
				System.out.println(" ");
				while(!childQueue.isEmpty()){
					mainStack.add(childQueue.remove());
				}
				level++;
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,
		120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		TreeNode node=construct(arr);
		levelOrderTraversalI(node);			
	}
	
}