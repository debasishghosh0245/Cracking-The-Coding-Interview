import java.util.*;
public class ConstructBinaryTreeFromString_536{
    
    private static class Node {
        int data;
        Node left;
        Node right;
        Node(){
        }
        Node(int data){
            this.data=data;
        }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    private static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
       }
    }

    private static void display(Node node) {
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
        StringBuilder str=new StringBuilder("-4(2(3)(1))(6(5)(7))");
        //StringBuilder str=new StringBuilder("4(2(3)(1))(6(5)(7))");
        //StringBuilder str=new StringBuilder("4");
        Node root2=deserialized(str,new Node());
        display(root2);
    }
    private static int idx=0;
    private static boolean isNegative=false;
    private static Node deserialized(StringBuilder str,Node node) {
      if(idx>str.length()) return null;
      if(str.charAt(idx)=='-') {
           idx++;
           isNegative=true;
      }
      if(str.charAt(idx)==')') {
            return null;
      }
      if(str.charAt(idx)=='(') {
            idx++;
      }
      if(isNegative){
         node=new Node(-Integer.parseInt(str.charAt(idx++)+"")); 
         isNegative=false;
      }else{
         node=new Node(Integer.parseInt(str.charAt(idx++)+"")); 
      }      
      node.left=deserialized(str,node); 
      node.right=deserialized(str,node);
      idx++;
      return node;   
    }   
}