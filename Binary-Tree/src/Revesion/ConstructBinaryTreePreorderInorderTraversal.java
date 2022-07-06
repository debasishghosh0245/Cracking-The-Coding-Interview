import java.util.*;
public class ConstructBinaryTreePreorderInorderTraversal {
	
	public static HashMap<Integer,Integer> inorderIdxMap=new HashMap<>();
    public static int preorder_idx=0;

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
	
	public static TreeNode constructTree(int left,int right,int[] preorder){
        if(left>right) return null;
        int rootNodeVal=preorder[preorder_idx++];
        TreeNode root=new TreeNode(rootNodeVal);
        root.left=constructTree(left,inorderIdxMap.get(rootNodeVal)-1,preorder);
        root.right=constructTree(inorderIdxMap.get(rootNodeVal)+1,right,preorder);
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
		//int[] preorder={3,9,20,15,7}; int[] inorder ={9,3,15,20,7};
		int[] preorder={-1}; int[] inorder ={-1};
		int idx=0;
        for(int i:inorder){
            inorderIdxMap.put(i,idx++);
        }
		System.out.println(inorderIdxMap);
        TreeNode node=ConstructBinaryTreePreorderInorderTraversal.
		constructTree(0,preorder.length-1,preorder);
		display(node);
	}	
}