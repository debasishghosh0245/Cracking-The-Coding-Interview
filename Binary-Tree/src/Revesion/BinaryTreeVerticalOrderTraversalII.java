import java.util.*;
public class BinaryTreeVerticalOrderTraversalII{

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

    public static class Pair implements Comparable<Pair>{
        int col;
        TreeNode node;
        Pair(TreeNode node,int col){
            this.node=node;
            this.col=col;
        }
        public int compareTo(Pair pair){
            return this.node.val-pair.node.val;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderII(TreeNode root){
        PriorityQueue<Pair> queue=new PriorityQueue<>();
        HashMap<Integer,ArrayList<Integer>> hashMap=new HashMap<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
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
                hashMap.putIfAbsent(currCol,new ArrayList<>());
                ArrayList<Integer> list=hashMap.get(currCol);
                list.add(currNode.val);
                hashMap.put(currCol,list);
                if(currNode.left!=null){
                    queue.offer(new Pair(currNode.left,currCol-1));
                }
                if(currNode.right!=null){
                    queue.offer(new Pair(currNode.right,currCol+1));
                }
            }
        }
        for(int i=minCol;i<=maxCol;i++){
            result.add(hashMap.get(i));
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
        Integer[] nums={25,50,12,null,null,67,30,null,null,null,75,37,null,60,null,null,87,null,null};
        TreeNode root=construct(nums);
        display(root);
        System.out.println(verticalOrderII(root));
    }
}
