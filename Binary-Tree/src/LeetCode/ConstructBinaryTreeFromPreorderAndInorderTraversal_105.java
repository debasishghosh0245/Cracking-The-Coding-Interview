import java.util.*;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105{

    protected static class Node{
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
        //int[] preorder={50,25,12,37,75,67,87};
        //int[] inorder={12,25,37,50,67,75,87};
        int[] preorder={3,9,20,15,7};
        int[] inorder ={9,3,15,20,7};
        Node root=construct(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        display(root);
    }
    
    public static Node construct(int[] preorder,int[] inorder,
        int prestart,int preend,int instart,int inend) {
        if(prestart > preend){
            return null;
        }
        int numsofnode=0;
        int idx=instart;
        while(inorder[idx]!=preorder[prestart]) {
            idx++;
            numsofnode++;
        }
        Node node=new Node(preorder[prestart]);
        node.left=construct(preorder,inorder,prestart+1,prestart+numsofnode,
        instart,idx-1);
        node.right=construct(preorder,inorder,prestart+numsofnode+1,preend,
        idx+1,inend);
        return node;
    }
}