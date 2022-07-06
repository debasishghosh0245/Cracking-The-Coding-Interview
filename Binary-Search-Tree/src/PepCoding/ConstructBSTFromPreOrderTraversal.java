public class ConstructBSTFromPreOrderTraversal {
   
    private static class Node {
         int data;
         Node left;
         Node right;
         Node(int data,Node left,Node right) {
             this.data=data;
             this.left=left;
             this.right=right;
         }
    }
    
    public static void display(Node root) {
        if(root==null) return;
        System.out.print(root.left!=null ? root.left.data+" ": "");
        System.out.print(root.data+" ");
        System.out.print(root.right!=null ? root.right.data+" " : " ");
        System.out.println("");
        display(root.left);
        display(root.right);
    }
    
    static int idx=0;
    public static Node construct(int[] preorder,int leftLimit,int rightLimit){
        if(idx >= preorder.length 
            || leftLimit > preorder[idx] 
                || preorder[idx] > rightLimit) return null;
        Node root=new Node(preorder[idx++],null,null);
        root.left=construct(preorder,leftLimit,root.data);
        root.right=construct(preorder,root.data,rightLimit);
        return root;
    }
    
    public static void main(String[] args) {
        int[] arr={50,25,12,37,30,40,75,67,60,70,87};
        Node root=construct(arr,Integer.MIN_VALUE,Integer.MAX_VALUE);
        display(root);
    }
}