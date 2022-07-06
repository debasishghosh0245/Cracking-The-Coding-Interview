import java.util.*;
public class BinaryTreeVerticalOrderTraversalSum{

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

    public static void verticalOrderSum(TreeNode root){
        Queue<Pair> queue=new LinkedList<>();
        HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
        int minCol=Integer.MAX_VALUE;
        int maxCol=Integer.MIN_VALUE;
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                Pair pair=queue.poll();
                minCol=Math.min(pair.col,minCol);
                maxCol=Math.max(pair.col,maxCol);
                int currCol=pair.col;
                TreeNode currNode=pair.node;
                hashMap.put(currCol,hashMap.getOrDefault(currCol,0)+currNode.val);
                if(currNode.left!=null){
                    queue.offer(new Pair(currNode.left,currCol-1));
                }
                if(currNode.right!=null){
                    queue.offer(new Pair(currNode.right,currCol+1));
                }
            }
        }
        for(int i=minCol;i<=maxCol;i++){
            System.out.println(hashMap.get(i));
        }
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
        verticalOrderSum(root);
    }
}
