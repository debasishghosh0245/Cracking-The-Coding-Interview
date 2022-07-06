public class PathSumII_113 {

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
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);
    }

    public static List<List<Integer>> pathSum(TreeNode root,int targetSum,List<Integer> path,List<List<Integer>> answer){
        if(root==null) {
            return answer;
        }
        //if we are reachable to root to leaf node
        if(root.left==null && root.right==null){
            if((targetSum-root.val)==0){
                path.add(root.val);
                answer.add(path);
            }
            return answer;
        }
        path.add(root.val);
        pathSum(root.left,targetSum-root.val,new ArrayList<>(path),answer);
        path.remove(path.size()-1);

        path.add(root.val);
        pathSum(root.right,targetSum-root.val,new ArrayList<>(path),answer);
        path.remove(path.size()-1);
        return answer;
    }

    public static void main(String[] args) {
        Integer[] nums={5,4,11,7,null,null,2,null,null,null,8,13,null,null,4,5,null,null,1,null,null};
        TreeNode root=constructBT(nums);
        //display(root);
        int targetSum=22;
        List<List<Integer>> answer=new ArrayList<>();
        pathSum(root,targetSum,new ArrayList<Integer>(),answer);
        System.out.println(answer);
    }
}
