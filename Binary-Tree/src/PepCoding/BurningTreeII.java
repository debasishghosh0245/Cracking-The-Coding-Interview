import java.util.*;
public class BurningTreeII {

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
        Integer[] arr = {50,25,12,null,null,37,30,null,null,40,null,null,
        75,65,60,null,null,70,null,null,87,null,null};
        Node root = construct(arr);
        List<Node> path=nodeToRootPath(root,37);
        int k=2;
        for(int i=0;i<path.size();i++) {
            printKLevelDown(path.get(i),k-i,i==0 ? null : path.get(i-1));
        }
    }
    
    public static int totalTimeToBurnTree(Node root,int val) {
        if(root==null) return -1;
        if(root.data==val) {
            brunTree(root,null,0);
            return 1;
        }
        int leftNodeburningTime=totalTimeToBurnTree(root.left,val);
        if(leftNodeburningTime!=-1){
           brunTree(root,root.left,leftNodeburningTime);
           return leftNodeburningTime+1;
        }
        int rightNodeburningTime=totalTimeToBurnTree(root.right,val);
        if(rightNodeburningTime!=-1){
            brunTree(root,root.right,rightNodeburningTime);
            return rightNodeburningTime+1;
        }       
        return -1;
    }
    
    public static void brunTree(Node root,Node blockerNode,int time){
        if(root==null || root==blockerNode) return;
        maxTime=Math.max(maxTime,time);
        brunTree(root.left,blockerNode,time+1);
        brunTree(root.right,blockerNode,time+1);
    }
}