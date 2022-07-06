import java.util.*;
public class AddNodeBinarySearchTree {
    
    static int idx=0;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode construct(Integer[] arr) {
        if(idx > arr.length || arr[idx]==null ) {
            idx++;
            return null;
        }
        TreeNode treeNode=new TreeNode(arr[idx++],null,null);
        treeNode.left=construct(arr);
        treeNode.right=construct(arr);
        return treeNode;
    }

    public static void display(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        String str = "";
        str += treeNode.left == null ? "." : treeNode.left.val + "";
        str += " <- " + treeNode.val + " -> ";
        str += treeNode.right == null ? "." : treeNode.right.val + "";
        System.out.println(str);
        display(treeNode.left);
        display(treeNode.right);
    }

    public static void main(String[] args) throws Exception {
        /* Integer[] arr={50,25,12,null,null,37,null,null,
        75,null,87,null,null};  */
        Integer[] arr={50,25,12,null,null,37,30,
        null,null,40,null,null,75,62,60,null,null,70,null,null,87,null,null};
        TreeNode root = construct(arr);
        add(root,61);
        display(root);
    }

    public static TreeNode add(TreeNode root,int data) {
        if(root==null){
            return new TreeNode(data,null,null);
        } 
        if(root.val > data) {
            root.left=add(root.left,data);
        }else if(root.val < data) {
            root.right=add(root.right,data);
        }
        else{
           // do nothing for equal value 
        }
        return root;
    }
}