public class PathSum_112{

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(TreeNode left,TreeNode right,int val) {
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }

    public static int idx=0;
    public static TreeNode construct(Integer[] nums){
        if( idx > nums.length ) return null;
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(null,null,nums[idx++]);
        root.left=construct(nums);
        root.right=construct(nums);
        return root;
    }

    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? " - < ":root.left.val+" < ");
        sb.append(root.val);
        sb.append(root.right==null ? " > - " : " > "+root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static boolean hasPathSum(TreeNode root,int target){
        //Base Case
        if(root==null) return false;
        if(root.left==null && root.right==null) return (target-root.val)==0;
        return hasPathSum(root.left,target-root.val) || hasPathSum(root.right,target-root.val);
    }

    public static void main(String[] args) {
        //if the tree has a root-to-leaf path // this has be end at leaf only
        Integer[] nums={5,4,11,7,null,null,2,null,null,null,8,13,null,null,4,null,1,null,null};
        //Integer[] nums={1,2,null,null,null};
        TreeNode root=construct(nums);
        display(root);
        int target=22;
        System.out.println("Path Sum >> "+hasPathSum(root,target));
    }
}
