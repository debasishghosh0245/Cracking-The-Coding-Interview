import java.util.*;
public class LowestCommonAncestorBinaryTree_236{
    
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
        /* Integer[] arr={50,25,12,null,null,37,30,null,null,40,null,null,
        75,60,null,null,70,null,null,87,null,null}; */
        /* Integer[] arr={3,5,6,null,null,2,7,null,null,4,null,null,1,0,null,null,
        8,null,null}; */
        Integer[] arr={1,2,null,null,null};
        TreeNode root = construct(arr);
        display(root);
        List<TreeNode> list1=TreeNodeToRootPath(root,1,new ArrayList<TreeNode>());
        System.out.println(list1);
        List<TreeNode> list2=TreeNodeToRootPath(root,2,new ArrayList<TreeNode>());
        System.out.println(list2);
        System.out.println("find LCA >> "+findLCA(list1,list2).val);
    }

    private static TreeNode findLCA(List<TreeNode> list1,List<TreeNode> list2){
        int i=list1.size()-1;
        int j=list2.size()-1;   
        while(i >= 0 && j >= 0 
            && list1.get(i).val==list2.get(j).val){
            i--;
            j--;
        }
        if(i < j) {
            return list1.get(i+1);
        }
        else {
            return list2.get(j+1);
        }
    }

    private static List<TreeNode> TreeNodeToRootPath(TreeNode root,int val,
        ArrayList<TreeNode> list) {
        if(root==null) return list;    
        if(root.val==val){
           list.add(root);
           return list;
        }
        List<TreeNode> left=TreeNodeToRootPath(root.left,val,list);
        if(left.size() > 0) {
             left.add(root);
             return left;
        }
        List<TreeNode> right=TreeNodeToRootPath(root.right,val,list);
        if(right.size() > 0) {
            right.add(root);
            return right;
        }
        return list;
    }

}