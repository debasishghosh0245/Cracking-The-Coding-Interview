import java.util.*;
public class PathSumII_113{

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
        Integer[] arr = {5,4,11,7,null,null,2,null,null,null,
        8,13,null,null,4,5,null,null,1,null,null};
        Node root = construct(arr);
        List<List<Integer>> output=pathSum(root,22,0,new ArrayList<Integer>(),new ArrayList<List<Integer>>());
        System.out.println(output);
    }
    
    public static List<List<Integer>> pathSum(Node root,int targetSum,int sumsf,List<Integer> path,List<List<Integer>> output) {        
        if(root==null) return output;
        if(root.left==null && root.right==null) {
            sumsf=sumsf+root.data;
            if(targetSum==sumsf) {
               path.add(root.data);
               output.add(path);
               return output;
            }
        }
        path.add(root.data);
        pathSum(root.left,targetSum,sumsf+root.data,new ArrayList<>(path),output);
        path.remove(path.size()-1);
        path.add(root.data);
        pathSum(root.right,targetSum,sumsf+root.data,new ArrayList<>(path),output);
        path.remove(path.size()-1);
        return output;
    }
}