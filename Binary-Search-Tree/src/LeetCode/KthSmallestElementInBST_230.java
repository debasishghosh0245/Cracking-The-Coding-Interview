import java.util.*;
public class KthSmallestElementInBST_230 {
    
    private static int ceil=Integer.MAX_VALUE;
    
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

    public static int max(Node root) {
        if(root==null) return Integer.MIN_VALUE;
        int left=max(root.left);
        int right=max(root.right);
        int max=Math.max(left,right);
        max=Math.max(max,root.data);
        return max;
    }

    public static void main(String[] args) throws Exception {
        Integer[] arr={50,25,12,null,null,37,30,null,null, 
        null,75,62,null,70,null,null,87,null,null};
        Node root = construct(arr);
        display(root);
        int k=3;
        List<Integer> list=inorder(root,new ArrayList<Integer>());
        System.out.println(list);
        System.out.println("Kth Smaller Element >> "+list.get(k));
        // int small=Integer.MIN_VALUE;
        // for(int i=0;i<k;i++) {
            // ceil=Integer.MAX_VALUE;
            // findCeil(root,small);
            // small=ceil;
        // }
        // System.out.println(small);
    }
    
    //Approach 1 :: findCeil 
    public static int findCeil(Node root,int key){
        if(root==null) return 0;
        if(key < root.data) {
            ceil=Math.min(ceil,root.data);
        }
        findCeil(root.left,key);
        findCeil(root.right,key); 
        return ceil;
    }
    
    //Approach 2 :: go for inorder traversal 
    //i will have the array in sorted array 
    
    public static List<Integer> inorder(Node root,List<Integer> list) {
        if(root==null) return list;
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
        return list;
    }
}
