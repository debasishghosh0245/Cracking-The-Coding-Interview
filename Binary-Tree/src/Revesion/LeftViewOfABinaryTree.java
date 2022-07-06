import java.util.*;
public class LeftViewOfABinaryTree{
	
	public static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val){
			this.val=val;
		}
		TreeNode(int val,TreeNode left,TreeNode right){
			this.val=val;
			this.left=left;
			this.right=right;
		}
	}
	
	static int idx=0;
	public static TreeNode construct(int[] arr){
		if(idx >=arr.length) return null;
		if(arr[idx]==-1) {
			idx++;
			return null;
		}
		TreeNode node=new TreeNode(arr[idx++]);
		node.left=construct(arr);
		node.right=construct(arr);
		return node;
	}

	public static List<List<Integer>> levelOrderTraveral(TreeNode root){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(root==null) return result;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root); 
		int size=0;
		while(!queue.isEmpty()){
			size=queue.size();
			List<Integer> temp=new ArrayList<>();
			for(int i=0;i<size;i++){
				TreeNode rmNode=queue.poll();
				temp.add(rmNode.val);
				if(null!=rmNode && null!=rmNode.left){
					queue.offer(rmNode.left);
				}
				if(rmNode!=null && null!=rmNode.right){
					queue.offer(rmNode.right);
				}
			}
			result.add(temp);
		}
		return result;
	}
	
	//Time Complexity  : O(N), where N is the total number of nodes in the tree.+O(n);
	//Space Complexity : O(N) for extra queue
	public static List<Integer> leftView(TreeNode root){
		List<List<Integer>> levelOrderResult=levelOrderTraveral(root);
		List<Integer> rightView=new ArrayList<>();
		for(List<Integer> list:levelOrderResult){
			rightView.add(list.get(0));
		}
		return rightView;
	}

	public static void display(TreeNode root){
		if(root==null) return;
		System.out.print(""+root.val+" ");
		display(root.left);
		display(root.right);
	}
	
	
	public static void main(String[] args){
		int[] arr={50,25,12,-1,-1,37,30,-1,-1,-1,75,62,-1,70,-1,-1,87,-1,-1};
		LeftViewOfABinaryTree binaryTree=new LeftViewOfABinaryTree();
		TreeNode node=binaryTree.construct(arr);
		System.out.println(leftView(node));
	}
}