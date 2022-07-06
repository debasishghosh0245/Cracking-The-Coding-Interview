import java.io.*;
import java.util.*;
public class SizeSumMaxMinFindInBst {
    
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
       }
    }
    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
                top.node.left = new Node(arr[idx], null, null);
                Pair lp = new Pair(top.node.left, 1);
            st.push(lp);
            } else {
                top.node.left = null;
            }
            top.state++;
        } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
                top.node.right = new Node(arr[idx], null, null);
                Pair rp = new Pair(top.node.right, 1);
                st.push(rp);
            } else {
                top.node.right = null;
            }
            top.state++;
        } else {
            st.pop();
        }
    }
        return root;
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
        Integer[]arr = {50,25,12,null,null,37,30,null,null,40,null,null,
        75,67,60,null,null,70,null,null,87,null,null};
        Node root = construct(arr);
        display(root);
        //System.out.println("Min >> "+min(root));
        //System.out.println("Max >> "+max(root));
        System.out.println("find "+find(root,69));
    }
    
    public static int size(Node root) {
      if(root==null) return 0;
      int left=size(root.left);
      int right=size(root.right);
      int size=left+right+1;
      return size;
   }

   public static int sum(Node root) {
     if(root==null) return 0;
     int left=sum(root.left);
     int right=sum(root.right);
     int sum=left+right+root.data;
     return sum;
   }

   public static int max(Node root) {
      if(root.right != null) {
			return max(root.right);
	  }else {
			return root.data;
	  }
   }

   public static int min(Node root) {
      if(root.left!=null){
          return min(root.left);
      }else{
          return root.data;
      }
   }

   public static boolean find(Node root, int key){
      if(root == null) return false;
      if(root.data == key) return true;
      if(key < root.data){
          boolean left=find(root.left,key);
          if(left) return true;
      }
      else if(key > root.data) {
          boolean right=find(root.right,key);
          if(right) return true; 
      }
      return false;
   }  
}