public class InsertIntoBinarySearchTree_701{
	
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
	
	public static int idx=0;
	public static TreeNode constructBST(Integer[] nums){
		if(idx >= nums.length) return null;
		if(nums[idx]==null) {
			idx++;
			return null;
		}
		TreeNode root=new TreeNode(nums[idx++]);
		root.left=constructBST(nums);
		root.right=constructBST(nums);
		return root;
	}
	
	public static TreeNode insert(TreeNode root,int val){
		if(root==null){
			return new TreeNode(val);
		}
		if(val < root.val) {
			root.left=insert(root.left,val);
		}
		if(val > root.val){
			root.right=insert(root.right,val);
		}
		return root;
	}
	
	public static void display(TreeNode root){
		if(root==null) return;
		System.out.print(root.val+" ");
		display(root.left);
		display(root.right);
	}
	
	public static void main(String[] args) {
		Integer[] nums ={4,2,1,null,null,7,null,null};
		TreeNode node=constructBST(nums);
		node=insert(node,3);
		display(node);
	}
}