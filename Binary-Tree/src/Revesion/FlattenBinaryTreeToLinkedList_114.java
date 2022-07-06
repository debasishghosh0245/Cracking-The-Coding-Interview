public class FlattenBinaryTreeToLinkedList_114{
	
	
	public static class TreeNode{
	    TreeNode left;
		TreeNode right;
		int val;
		
		TreeNode(int val){
			this.val=val;
		}
		
		TreeNode(TreeNode left,TreeNode right,int val){
			this.val=val;
			this.left=left;
			this.right=right;
		}
		
	}
	static int idx=0;
	public static TreeNode constructBT(Integer[] nums) {
		if(idx>=nums.length) return null;
		
		if(nums[idx]==null) {
			idx++;
			return null;
		}
		
		TreeNode root=new TreeNode(nums[idx++]);
		root.left=constructBT(nums);
		root.right=constructBT(nums);
		return root;
	}
	
	public static void display(TreeNode root){
		if(root==null) return;
		StringBuilder sb=new StringBuilder();
		sb.append(root.left==null ? " . < "  : root.left.val+" < " );
		sb.append(" "+root.val+" ");
		sb.append(root.right==null ? " > .  " : " > "+root.right.val); 
		System.out.println(sb);
		display(root.left);
		display(root.right);
	}
	
	public static TreeNode getLeftTail(TreeNode node) {
		if(node.left!=null) return node;
		TreeNode lefttail=getLeftTail((node.left));
		return lefttail;
	}

	public static TreeNode flattenTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode leftTail=flattenTree(node.left);
        TreeNode rightTail=flattenTree(node.right);
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rightTail==null ? leftTail : rightTail;
    }

	public static void main(String[] args){
		
		Integer[] nums={1,2,3,null,null,4,null,null,5,null,6,null,null};
		TreeNode node=constructBT(nums);
		display(node);
		flattenTree(node);
		System.out.println("Print Flatten Binary Tree");
		display(node);
	}

}