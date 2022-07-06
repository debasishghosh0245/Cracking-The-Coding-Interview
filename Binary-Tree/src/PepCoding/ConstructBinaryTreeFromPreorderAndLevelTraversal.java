import java.util.*;
public class ConstructBinaryTreeFromPreorderAndLevelTraversal{
    
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
        int[] inorder={12,25,37,50,67,75,87};
        int[] levelorder={50,25,75,12,37,67,87};
        Node root=construct(levelorder,inorder,0,inorder.length-1);
        display(root);
    }
    
    private static Node construct(int[] levelOrder,int[] inOrder,int inStart,
        int inEnd) {
            if(inStart > inEnd) {
                return null;
            }
            Node node=new Node(levelOrder[0]);
            int idx=inStart;
            while(inOrder[idx]!=levelOrder[0]) {
               idx++; 
            }
            HashSet<Integer> hashSet=new HashSet<>();
            for(int i=inStart;i<idx;i++) {
                hashSet.add(inOrder[i]);
            }
            int[] levelOrderLeft=new int[idx-inStart];
            int[] levelOrderRight=new int[inEnd-idx];
            int levelOrderLeftIdx=0;
            int levelOrderRightIdx=0;
            for(int i=1;i<levelOrder.length;i++) {
               if(!hashSet.isEmpty() && hashSet.contains(levelOrder[i])){
                   levelOrderLeft[levelOrderLeftIdx++]=levelOrder[i];
                   hashSet.remove(levelOrder[i]);
               }else{
                   levelOrderRight[levelOrderRightIdx++]=levelOrder[i];
               }
            }
            node.left=construct(levelOrderLeft,inOrder,inStart,idx-1);
            node.right=construct(levelOrderRight,inOrder,idx+1,inEnd);
            return node;
    }
}