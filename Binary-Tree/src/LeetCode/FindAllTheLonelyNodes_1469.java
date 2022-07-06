import java.util.*;
public class FindAllTheLonelyNodes_1469 {
    
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
        //Integer[] arr={10,20,40,null,null,50,null,80, null,null,30,60,90,null,null,null,70,null,null};
        Integer[] arr={31,null,78,null,28,null,null};
        Node root = construct(arr);
        List<Integer> list=printSingleChildNodes(root,null,new ArrayList<>());
        System.out.println(list);
    }
    
    public static List<Integer> printSingleChildNodes(Node node,Node parent,List<Integer> list) {
        if(node==null) {
            return new ArrayList<Integer>();  
        }
        if(null!=parent && parent.left!=null && parent.right==null) {
            list.add(node.data);
        }
        if(null!=parent && parent.right!=null && parent.left==null) {
            list.add(node.data);
        }
        printSingleChildNodes(node.left,node,list);
        printSingleChildNodes(node.right,node,list);
        return list;
    }
}