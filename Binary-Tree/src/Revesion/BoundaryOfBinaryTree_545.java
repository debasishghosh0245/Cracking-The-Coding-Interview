import java.util.*;
public class BoundaryOfBinaryTree_545{

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
	public static TreeNode construct(Integer[] nums){
		if(idx >=nums.length) return null;
		if(nums[idx]==null){
			idx++;
			return null;
		}
		TreeNode root=new TreeNode(nums[idx++]);
		root.left=construct(nums);
		root.right=construct(nums);
		return root;
	}
	
	public static void display(TreeNode root){
		if(root==null) return;
		System.out.print(root.val+" ");
		display(root.left);
		display(root.right);
	}
	
	public static List<Integer> addleftView(TreeNode root,List<Integer> list){
		if(root==null){
			return list; 
		} 
		if(!isLeafNode(root)){
			list.add(root.val);
		}
		if(root.left!=null){
			addleftView(root.left,list);
		}else{
			addleftView(root.right,list);
		}
		return list;
	}
	
	public static List<Integer> addRightView(TreeNode root,List<Integer> list){
		if(root==null){
			return list; 
		} 
		if(root.right!=null){
			addRightView(root.right,list);
		}else{
			addRightView(root.left,list);
		}
		if(!isLeafNode(root)){
			list.add(root.val);
		}
		return list;
	}
	
	
	public static List<Integer> addLeafNode(TreeNode root,List<Integer> list){
		//System.out.println(root.val);
		if(root==null) return list;
		if(root.left==null && root.right==null){
			list.add(root.val);
			return list;
		}
		addLeafNode(root.left,list);
		addLeafNode(root.right,list);
		return list;
	}
	
	public static boolean isLeafNode(TreeNode root){
		return root.left==null && root.right==null;
	}
	
	public static void main(String[] args) {
		Integer[] nums={50,25,12,null,null,37,30,null,null,null,75,70,
		null,65,null,null,87,null,null};
		TreeNode node=construct(nums);
		List<Integer> result=new ArrayList<>();
		if(!isLeafNode(node)){
			result.add(node.val);
		}
		addleftView(node.left,result);
		addLeafNode(node,result);
		addRightView(node.right,result);
		System.out.println(result);
	}
}