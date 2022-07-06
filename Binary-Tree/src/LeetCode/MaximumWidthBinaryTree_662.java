import java.util.*;
public class MaximumWidthBinaryTree_662{
    
    private static int max=0;
    
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
        //Integer[]arr = {1,3,5,null,null,3,null,null,2,null,9,null,null};
        //Integer[] arr={1,3,5,null,null,null,2,null,null};
        Integer[] arr={1,3,5,null,null,null,2,null,null};
        Node root = construct(arr);
        maxWidthOfBinaryTree(root);
        System.out.println("Max >> "+max);
    }
    public static class PairCol{
        Node node;
        int idx;
        PairCol(Node node,int idx) {
            this.node=node;
            this.idx=idx;
        }
    }
    public static void maxWidthOfBinaryTree(Node root) {
        Queue<PairCol> queue=new ArrayDeque<>();
        queue.add(new PairCol(root,0)); 
        while(!queue.isEmpty()) {
            int size=queue.size();
            int leftMostIdx=0;
            int rightMostIdx=0;
            leftMostIdx=queue.peek().idx;
            for(int i=0;i<size;i++) {
                PairCol pairCol=queue.remove();
                rightMostIdx=pairCol.idx;
                if(null!=pairCol.node.left){
                    queue.add(new PairCol(pairCol.node.left,2*pairCol.idx+1)); 
                }
                if(null!=pairCol.node.right) {
                    queue.add(new PairCol(pairCol.node.right,2*pairCol.idx+2));   
                } 
            }
            max=Math.max(max,(rightMostIdx-leftMostIdx+1));  
        }
    }
}