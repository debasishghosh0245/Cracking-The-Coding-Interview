import java.util.*;
public class PathSumIII_437{

    public static int countPath=0;

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
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
        if(idx >= nums.length ) return null;
        if(nums[idx]==null) {
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=constructBT(nums);
        root.right=constructBT(nums);
        return root;
    }

    public static void display(TreeNode root) {
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? " - < ":root.left.val+" < ");
        sb.append(root.val);
        sb.append(root.right==null ? " > - " : " > "+root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static void countTargetSumPath(TreeNode root,int targetSum){
        if(root==null ) return;
        if(targetSum==root.val){
            countPath++;
        }
        countTargetSumPath(root.left,targetSum-root.val);
        countTargetSumPath(root.right,targetSum-root.val);
    }

    public static void pathSum(TreeNode root,int targetSum){
        if(root==null) return;
        countTargetSumPath(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
    }

    public static void main(String[] args){
        //Integer[] nums={10,5,3,3,null,null,-2,null,null,2,null,1,null,null,-3,null,11,null,null};
        //Integer[] nums={5,4,11,7,null,null,2,null,null,null,8,13,null,null,4,null,1,null,null};
        //Integer[] nums={5,4,11,7,5,null,null,1,null,null,2,null,null,null,8,13,null,null,4,5,null,null,null};
        //Integer[] nums={-2,null,-3,null,null};
        Integer[] nums={1,-2,1,-1,null,null,null,3,null,null,-3,-2,null,null,null};
        TreeNode root=constructBT(nums);
        display(root);
        int targetSum=-1;
        //System.out.println(countTargetSumPath(root,targetSum));
        pathSum(root,targetSum);
        System.out.println(countPath);
    }
}
