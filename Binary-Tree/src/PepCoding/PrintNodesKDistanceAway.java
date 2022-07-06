import java.util.*;
public class PrintNodesKDistanceAway{

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
  
        //System.out.println(ans);
    }
    
    public static List<Node> nodeToRootPath(Node root,int val) {
        List<Node> path=null;
        if(root==null) return null;
        if(root.data==val) {
            path=new ArrayList<>();
            path.add(root);
            return path;
        }
        List<Node> leftPath=nodeToRootPath(root.left,val);
        if(null!=leftPath && leftPath.size()>0){
            leftPath.add(root);
            return leftPath;
        }
        List<Node> rightPath=nodeToRootPath(root.right,val);
        if(rightPath!=null && rightPath.size()>0){
            rightPath.add(root);
            return rightPath;
        }        
        return path;
    }
    
    public static void printKLevelDown(Node root, int k,Node blockerNode){
        if(root==null || k < 0 || root==blockerNode) return;
        if(k==0) {
            System.out.print(root.data +" ");
        }
        printKLevelDown(root.left,k-1,blockerNode);
        printKLevelDown(root.right,k-1,blockerNode);
    }
}