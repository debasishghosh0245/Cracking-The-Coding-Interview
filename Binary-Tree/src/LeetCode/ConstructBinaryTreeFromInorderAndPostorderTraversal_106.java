import java.util.*;
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106{

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
        int[] postorder={12,30,40,37,25,60,70,67,87,75,50};
        int[] inorder ={12,25,30,37,40,50,60,67,70,75,87};
        Node root=construct(postorder,inorder,0,postorder.length-1,0,inorder.length-1);
        display(root);
    }
    
    public static Node construct(int[] postorder,int[] inorder,
        int poststart,int postend,int instart,int inend) {
        if(poststart > postend){
            return null;
        }
        int numsofnode=0;
        int idx=instart;
        while(inorder[idx]!=postorder[postend]) {
            idx++;
            numsofnode++;
        }
        Node node=new Node(postorder[postend]);
        node.left=construct(postorder,inorder,poststart,poststart+numsofnode-1,
        instart,idx-1);
        node.right=construct(postorder,inorder,poststart+numsofnode,postend-1,
        idx+1,inend);
        return node;
    }
}