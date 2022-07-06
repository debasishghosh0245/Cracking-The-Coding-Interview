import java.util.*;
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106{
	
	public static HashMap<Integer,Integer> inorderIdxMap=new HashMap<>();
    public static int postorder_idx=0;

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
	
	public static TreeNode constructTree(int left,int right,int[] postorder){
        if(left > right) return null;
        int rootNodeVal=postorder[postorder_idx--];
        TreeNode root=new TreeNode(rootNodeVal);
		root.right=constructTree(inorderIdxMap.get(rootNodeVal)+1,right,postorder);
        root.left=constructTree(left,inorderIdxMap.get(rootNodeVal)-1,postorder);
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
		int[] postorder={9,15,7,20,3}; int[] inorder ={9,3,15,20,7};
		int idx=0;
        for(int i:inorder){
            inorderIdxMap.put(i,idx++);
        }
		System.out.println(inorderIdxMap);
		postorder_idx=postorder.length-1;
        TreeNode node=constructTree(0,postorder.length-1,postorder);
		display(node);
	}	

}