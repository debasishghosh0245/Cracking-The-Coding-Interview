public class ConstructBSTFromPostOrderTraversal {
   
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
    public static Node construct(int[] postorder,int leftLimit,int rightLimit){
        if(idx < 0 
          || postorder[idx] < leftLimit
          || postorder[idx] > rightLimit) return null;
        Node root=new Node(postorder[idx--],null,null);
        root.right=construct(postorder,root.data,rightLimit);
        root.left=construct(postorder,leftLimit,root.data);
        return root;
    }
    
    public static void main(String[] args) {
        int[] postorder={12,30,40,37,25,70,80,67,87,75,50};
        idx=postorder.length-1;
        Node root=construct(postorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        display(root);
    }
}