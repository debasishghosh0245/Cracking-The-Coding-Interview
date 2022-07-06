public class LargestBSTSubtree_333 {
	
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
	
	private static class Pair{
		boolean isValid;
		int size=0;
		long min=Long.MIN_VALUE;
		long max=Long.MAX_VALUE;
		Pair(){
		}
		Pair(boolean isValid,int size,long min,long max){
			this.isValid=isValid;
			this.size=size;
			this.min=min;
			this.max=max;
		}
	}
	
	//Time Complexity: O(n) Time
	//Space Complexty: O(n) Space 
	public static Pair validateBST(TreeNode root){
		if (root == null) {
			Pair pair=new Pair(true,0,Long.MAX_VALUE,Long.MIN_VALUE);
			return pair;
		}
		Pair left = validateBST(root.left);
		Pair right = validateBST(root.right);
		Pair pair=new Pair();
		if (left.isValid && right.isValid 
			&& root.val > left.max && root.val < right.min) {
			pair.isValid=true;
			pair.min=Math.min(root.val,left.min);
			pair.max=Math.max(root.val,right.max);
			pair.size=1+left.size+right.size;
			return pair;
		}else{
			pair.isValid=false;
			pair.min=Long.MAX_VALUE;
			pair.max=Long.MIN_VALUE;
			pair.size=Math.max(left.size,right.size);
			return pair;
		}
	}  

	public static void main(String[] args){
		Integer[] nums={10,5,1,null,null,8,null,null,15,null,7,null,null};
		TreeNode node=constructBST(nums);
		//display(node);	
		System.out.println(validateBST(node).size);
	}

}