public class HouseRobberIII_337{

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

    public static class Pair{
        int rob;
        int notRob;
    }

    //Time Complexity :
    //Space Complexity:
    public static Pair rob(TreeNode root){
        if(root==null){
            return new Pair();
        }
        Pair left=rob(root.left);
        Pair right=rob(root.right);
        Pair pair=new Pair();
        pair.rob=root.val+left.notRob+right.notRob;
        pair.notRob=Math.max(left.rob,left.notRob)+Math.max(right.rob,right.notRob);
        return pair;
    }

    //Time Complexity:O(n)
    //Space Complexity:O(n) height of the tree
    public static int[] robHelper(TreeNode root){
        if(root==null){
            return new int[2];
        }
        int[] left=robHelper(root.left);
        int[] right=robHelper(root.right);
        int[] arr=new int[2];
        arr[0]=root.val+left[1]+right[1];
        arr[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return arr;
    }

    public static void main(String[] args){
        Integer[] nums={3,2,null,3,null,null,3,null,1,null,null};
        //Integer[] nums={3,4,1,null,null,3,null,null,5,null,1,null,null};
        //Integer[] nums={1,null,null};
        //Integer[] nums={1,null,2,null,null};
        TreeNode root=constructBT(nums);
        display(root);
        int[] pair=robHelper(root);
        System.out.println(Math.max(pair[0],pair[1]));
    }

}
