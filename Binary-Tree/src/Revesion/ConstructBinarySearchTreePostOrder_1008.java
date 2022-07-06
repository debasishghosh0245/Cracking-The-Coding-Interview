public class ConstructBinarySearchTreePostOrder_1008{
	
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
  
    //static int idx=0;
    public static TreeNode constructBST(int[] postorder,int left,int right) {
		if (left > right) return null;
        TreeNode root = new TreeNode(postorder[right]);
		if (left == right) return root;
		int cnt = 0;
		for (int idx = left; idx < right; idx++) {
			if (postorder[idx] < root.val) {
				cnt++;
			} else {
				break;
			}
		}
		//System.out.println("preorder left " + left);
		//System.out.println("preorder right " + (left + cnt - 1));
		root.left = constructBST(postorder, left, left + cnt - 1);
		//System.out.println("postorder left " + (left + cnt));
		//System.out.println("postorder right " + right);
		root.right = constructBST(postorder, left + cnt, right - 1);
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
		int[] postorder={1,2,3,6,5,3};
		TreeNode root=new TreeNode(postorder[postorder.length-1]);
		TreeNode treeNode=constructBST(postorder,0,postorder.length-1);
		display(treeNode);
	}
	

}