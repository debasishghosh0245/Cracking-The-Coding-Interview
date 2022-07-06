public class InvertBinaryTree_226{

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
    public static TreeNode constructBT(Integer[] nums){
        if(idx>=nums.length){
            return null;
        }
        if(nums[idx]==null){
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
        sb.append(root.left==null ? "-" :root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-":root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static TreeNode invert(TreeNode root){
        if(root==null) return null;
        TreeNode left=invert(root.left);
        TreeNode right=invert(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

    public static void main(String[] args){
        Integer[] nums={4,2,1,null,null,3,null,null,7,6,null,null,9,null,null};
        TreeNode root=constructBT(nums);
        display(root);
        invert(root);
        System.out.println("Tree is Inverted >>");
        display(root);
    }
}
