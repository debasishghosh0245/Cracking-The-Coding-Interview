public class ConvertSortedArrayBinarySearchTree_108{
	
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
  
    public static TreeNode constructBST(int[] inorder,int left,int right) {
       if(left>right) return null;
	   int mid=(left+right)/2;
	   TreeNode root=new TreeNode(inorder[mid]);
	   root.left=constructBST(inorder,left,mid-1);
	   root.right=constructBST(inorder,mid+1,right);
	   return root;
    }
	
	public static void display(TreeNode root){
		if(root==null) return;
		 StringBuilder sb = new StringBuilder();
        sb.append((root.left != null ? root.left.val : "."));
        sb.append(" -> " + root.val + " <- ");
        sb.append((root.right != null ? root.right.val : "."));
        System.out.println(sb.toString());
		display(root.left);
		display(root.right);
	}
	
	public static void main(String[] args){
		int[] nums={-10,-3,0,5,9};
		TreeNode treeNode=constructBST(nums,0,nums.length-1);
		display(treeNode);
	}
}