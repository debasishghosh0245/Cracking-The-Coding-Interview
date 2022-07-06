public class ValidateBinarySearchTree_98 {
	
	public static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		TreeNode(int val){
			this.val=val;
		}
		
		TreeNode(TreeNode left,TreeNode right,int val){
			this.left=left;
			this.right=right;
			this.val=val;
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
	
	public static void display(TreeNode node){
		if(node==null) return;
		System.out.print(node.val+" ");
		display(node.left);
		display(node.right);
	}
	

	
	public static boolean validateBST(int min,TreeNode root,int max){
		if (root == null) return true;
		boolean isValid_left = validateBST(min, root.left, root.val);
		boolean isValid_right = validateBST(root.val, root.right, max);
		if (isValid_left && isValid_right && root.val > min && root.val < max)
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args){
		Integer[] nums={5,1,4,null,null,3,6};
		TreeNode node=constructBST(nums);
		display(node);	
		System.out.println(validateBST(Integer.MIN_VALUE,node,Integer.MAX_VALUE));
	}

}