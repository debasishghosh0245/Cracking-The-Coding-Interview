import java.util.*;
public class  MaximumLevelSumOfABinaryTree1161 {
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
        if(idx >= nums.length){
            return null;
        }
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
        if(root==null){
            return;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-":root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-":root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static int levelOrderMaxSum(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        int maxSumLevel=Integer.MIN_VALUE;
        int maxSum=Integer.MIN_VALUE;
        int currLevel=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int currSum=0;
            currLevel++;
            while(size-->0){
                TreeNode removedNode=queue.poll();
                currSum+=removedNode.val;
                if(removedNode.left!=null){
                    queue.offer(removedNode.left);
                }
                if(removedNode.right!=null){
                    queue.offer(removedNode.right);
                }
            }
            if(currSum>maxSum){
                maxSumLevel=currLevel;
                maxSum=currSum;
            }
        }
        return maxSumLevel;
    }

    public static void main(String[] args){
        //Integer[] nums={1,7,7,null,null,-8,null,null,0,null,null};
        Integer[] nums={989,null,10250,98693,-89388,null,null,null,-32127};
        TreeNode root=construct(nums);
        display(root);
        System.out.println(levelOrderMaxSum(root));
    }
}
