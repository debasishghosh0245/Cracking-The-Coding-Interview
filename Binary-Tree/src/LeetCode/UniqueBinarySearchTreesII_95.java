import java.util.*;
public class UniqueBinarySearchTreesII_95 {
   
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(){};
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
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

    public static void main(String[] args) throws Exception {
        List<Node> ans=new ArrayList<>();
        generateTrees(2,3,ans);
        for(int i=0;i<ans.size();i++){
            display(ans.get(i));
        }
    }
    
    public static Node generateTrees(int start,int end,List<Node> list) {
        Node root=null;
        if(start>end){
            return null;
        }
        for(int i=start;i<=end;i++){
            Node left=generateTrees(start,i-1,list);
            Node right=generateTrees(i+1,end,list);
            root=new Node(i);
            root.left=left;
            root.right=right;
            list.add(root);
        }
        
        return root;
    }
}
