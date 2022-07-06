import java.util.*;
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal{

    private static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right) {
            this.data=data;
            this.left=left;
            this.right=right;
        }
        Node(int data) {
            this.data=data;
        }
    }
    
    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    
    public static void main(String[] args) {
        int[] preorder={50,25,12,37,75,67,87};
        int[] postorder={12,37,25,67,87,75,50};
        Node root=construct(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
        display(root);
    }
    
    private static Node construct(int[] preorder,int[] postorder,
        int prestart,int preend,int poststart,int postend) {
        if(prestart > preend){
            return null;
        }
        Node node=new Node(preorder[prestart]);
        if(prestart==preend) {
            return node;
        }
        int numsofnode=0;
        int idx=poststart;
        while(postorder[idx]!=preorder[prestart+1]) {
            idx++;
            numsofnode++;
        }
        node.left=construct(preorder,postorder,prestart+1,prestart+1+numsofnode,
        poststart,idx-1);
        node.right=construct(preorder,postorder,prestart+numsofnode+2,preend,
        idx+1,postend-1);
        return node;
    }
}