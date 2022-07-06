public class ConstructBinarySearchTreePostOrderTraversal_1008{
	
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

    public static TreeNode constructBST(int[] preorder,int left,int right) {
		if(left > right) return null;
		TreeNode node=new TreeNode(preorder[left]);
		if(left == right) return node;
		int cnt=0;
		for(int idx=left+1;idx <=right;idx++){
			if(idx < preorder.length && preorder[idx] < node.val){
				cnt++;
			}else{
				break;
			}
		}
		//System.out.println("left "+(left+1));
		//System.out.println("right "+(left+cnt));
		node.left=constructBST(preorder,left+1,left+cnt);
		//System.out.println("left "+(left+cnt));
		//System.out.println("right "+right);
		node.right=constructBST(preorder,left+cnt+1,right);
		return node;
    }
	
	/* public static TreeNode constructBST(int[] preorder,int left,int right) {
		if(left > right) return null;
		TreeNode node=new TreeNode(preorder[left]);
		if(left == right) return node;
		int cnt=0;
		for(int idx=left+1;idx <=right;idx++){
			if(idx < preorder.length && preorder[idx] < node.val){
				cnt++;
			}else{
				break;
			}
		}
		node.left=constructBST(preorder,left+1,left+cnt);
		node.right=constructBST(preorder,left+cnt+1,right);
		return node;
    } */
	
	public static int idx=0;
	public static TreeNode constructBSTII(int[] preorder,int min,int max,TreeNode node) {
		//if the index is out of range return null
		if(idx >= preorder.length ) return null;
		int val=preorder[idx];
		
		System.out.println("root "+val);
		System.out.println("min  "+min);
		System.out.println("max  "+max);
	
		//if the current element is not valid to place here to meet to BST Properties
		if(val < min || val > max){
			return null;
		} 
		// place the current element
		// and recursively construct subtrees
		idx++;
		TreeNode root=new TreeNode(val);

		root.left=constructBSTII(preorder,min,root.val,root);
		root.right=constructBSTII(preorder,root.val,max,root);
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
		int[] preorder={8,5,1,7,10,12};
		//int[] preorder={4,2};
		//TreeNode treeNode=constructBST(preorder,0,preorder.length-1);
		TreeNode node=constructBSTII(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE,null);
		display(node);
	}

}