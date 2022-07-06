import java.util.*;
public class BinaryTreeCameras_968 {
    
    protected static int minCameraCnt=0;
     
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
            }  else if (top.state == 2) {
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
        Integer[] arr = {1,null,2,3,null,null,4,null,null};
        /* Integer[] arr={50,20,12,null,null,37,30,null,null,40,null,null,
        75,67,60,null,null,70,null,null,87,null,null}; */ 
        //Integer[] arr={0,null,null};
        Node root = construct(arr);
        if(minCameraCnt(root)==-1) {
            minCameraCnt+=1;
        } 
        System.out.println("Minimum Camera Required >> "+minCameraCnt);
    }
        
    public static int minCameraCnt(Node root) {
        if(root==null) return 1;
        int left=minCameraCnt(root.left);
        int right=minCameraCnt(root.right);
        if(left==-1 || right==-1) {
            minCameraCnt++;
            return 0;
        }
        else if(left==0 || right==0) {
            return 1;
        }
        else{
          return -1;     
        }   
   }
}