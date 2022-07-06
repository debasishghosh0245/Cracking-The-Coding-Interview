public class DiameterOfBinaryTree_543 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode (int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public static int idx=0;
    public static TreeNode construct(Integer[]  nums){
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
        sb.append(root.left==null ? " - < ":root.left.val+" < ");
        sb.append(root.val);
        sb.append(root.right==null ? " > - " : " > "+root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }

    public static class Pair{
        int maxDiameter=Integer.MIN_VALUE;
        int maxRootToNodePathLength=-1;
    }

    //Appraoch 1 :
    //Time Complexity :: O(n) Recursive Perorder Traversal time
    //Space Complexity ::O(n) Height of the tree + extra Pair class Space
    public static Pair diameter(TreeNode root){
        if(root==null) {
            Pair pair=new Pair();
            return pair;
        }
        Pair leftPair=diameter(root.left);
        Pair rightPair=diameter(root.right);
        Pair pair=new Pair();
        pair.maxRootToNodePathLength=1+Math.max(leftPair.maxRootToNodePathLength,rightPair.maxRootToNodePathLength);
        pair.maxDiameter=Math.max(2+leftPair.maxRootToNodePathLength+rightPair.maxRootToNodePathLength,
        Math.max(leftPair.maxDiameter,rightPair.maxDiameter));
        return pair;
    }

    //Appraoch 2 :With out Pair Class
    public static int[] diameter_02(TreeNode root){
        if(root==null) {
            int[] arr=new int[2];
            arr[0]=-1;
            arr[1]=Integer.MIN_VALUE;
            return arr;
        }
        int[] left=diameter_02(root.left);
        int[] right=diameter_02(root.right);
        int[] pair=new int[2];
        pair[0]=1+Math.max(left[0],right[0]);
        pair[1]=Math.max(2+left[0]+right[0],
        Math.max(left[1],right[1]));
        return pair;
    }

    //Appraoch 2 :With the heap Mover methods
    //** here only maxOfNodeToRootPath is changing parameter
    // or height is chaning
    public static int diameter=0;
    public static int diameter_03(TreeNode root){
        if(root==null) {
            return -1;
        }
        int leftHeight=diameter_03(root.left);
        int rightHeight=diameter_03(root.right);
        diameter=Math.max(leftHeight+rightHeight+2,diameter);
        return 1+Math.max(leftHeight,rightHeight);
    }

    public static void main(String[] args) {
        Integer[] nums={1,2,4,null,null,5,null,null,3,null,null};
        TreeNode node=construct(nums);
        display(node);
        diameter_03(node);
        System.out.println(diameter);
    }
}
