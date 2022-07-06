import java.util.*;
public class DiagonalOrderSumOfABinaryTree {

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

    public static class Pair{
        int col;
        TreeNode node;
        Pair(TreeNode node,int col){
            this.node=node;
            this.col=col;
        }
    }

    public static ArrayList<Integer> diagonalOrderTraversal(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> result=new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int currSum=0;
            while(size-->0){
                TreeNode currNode=queue.poll();
                while(currNode!=null){
                    currSum+=currNode.val;
                    if(currNode.left!=null){
                        queue.offer(currNode.left);
                    }
                    currNode=currNode.right;
                }
            }
            result.add(currSum);
        }
        return result;
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

    public static void main(String[] args){
        Integer[] nums={25,50,12,null,null,37,30,null,null,null,75,67,null,60,null,null,87,null,null};
        TreeNode root=construct(nums);
        display(root);
        System.out.println(diagonalOrderTraversal(root));
    }
}
