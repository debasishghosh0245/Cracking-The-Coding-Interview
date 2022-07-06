public class MaximumPathSumInBetweenTwoLeavesOfBinaryTree{

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
    public static TreeNode construct(Integer[] nums){
        if(idx >= nums.length) return null;
        if(nums[idx]==null){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=construct(nums);
        root.right=construct(nums);
        return root;
    }

    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-":root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-":root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static class Pair{
        int maxRootToLeafPathSum=0;
        int maxLeafToLeafPahSum=0;
    }

    public static Pair maxPathSumLeafNode(TreeNode root){
        if(root==null){
            return new Pair();
        }
        Pair left=maxPathSumLeafNode(root.left);
        Pair right=maxPathSumLeafNode(root.right);
        Pair pair=new Pair();
        pair.maxRootToLeafPathSum=root.val+Math.max(left.maxRootToLeafPathSum,right.maxRootToLeafPathSum);
        if(left.maxLeafToLeafPahSum!=0 && right.maxLeafToLeafPahSum!=0){
            pair.maxLeafToLeafPahSum=0;
        }else{
            pair.maxLeafToLeafPahSum=Math.max(root.val+left.maxRootToLeafPathSum+right.maxRootToLeafPathSum,
            Math.max(left.maxLeafToLeafPahSum,right.maxLeafToLeafPahSum));
        }
        return pair;
    }

    public static void main(String[] args){
        //Integer[] nums={5,2,1,null,null,3,4,null,null,null,7,6,null,null,8,null,null};
        Integer[] nums={1,2,null,-4,null,null,3,5,7,null,null,8,null,null,6,null,null};
        TreeNode root=construct(nums);
        display(root);
        System.out.println("Max Sum >>"+maxPathSumLeafNode(root).maxLeafToLeafPahSum);
    }
}
