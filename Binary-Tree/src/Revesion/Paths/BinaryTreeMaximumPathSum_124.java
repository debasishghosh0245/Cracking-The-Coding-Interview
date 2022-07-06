public class BinaryTreeMaximumPathSum_124 {

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

    public static class Pair{
        int maxRootToNodePathSum=0;
        int maxPathSum=Integer.MIN_VALUE;
    }

    //approach 1: with the Pair Class
    public static Pair maxPathSum_01(TreeNode root){
        if(root==null ){
            Pair pair=new Pair();
            return pair;
        }
        Pair leftPair=maxPathSum_01(root.left);
        Pair rightPair=maxPathSum_01(root.right);
        Pair pair=new Pair();
        pair.maxRootToNodePathSum=root.val+Math.max(leftPair.maxRootToNodePathSum,rightPair.maxRootToNodePathSum);
        pair.maxPathSum=Math.max(Math.max(leftPair.maxPathSum,rightPair.maxPathSum),root.val
        +leftPair.maxRootToNodePathSum+rightPair.maxRootToNodePathSum);
        return pair;
    }

    public static int maxPathSum=Integer.MIN_VALUE;
    //approach 1: with static variable
    public static int maxPathSum_03(TreeNode root){
        if(root==null ){
            return 0;
        }
        int left=Math.max(0,maxPathSum_03(root.left));
        int right=Math.max(0,maxPathSum_03(root.right));
        maxPathSum=Math.max(maxPathSum,root.val+left+right);
        return root.val+Math.max(left,right);
    }

    public static void main(String[] args) {
        //Integer[] nums={0,null,null};
        //Integer[] nums={-10,9,null,null,20,15,null,null,7,null,null};
        //Integer[] nums={1,-2,1,-1,null,null,null,3,null,null,-3,-2,null,null,null};
        //Integer[] nums={-3,null,null};
        Integer[] nums={2,-1,null,null,null};
        TreeNode root=construct(nums);
        display(root);
        maxPathSum_03(root);
        System.out.println("Maximum Path Sum "+maxPathSum);
    }

}
