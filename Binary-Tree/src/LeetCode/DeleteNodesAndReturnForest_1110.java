import java.util.*;
public class DeleteNodesAndReturnForest_1110 {
    
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        
        Node(int data) {
            this.data=data;
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
        Integer[] arr={1,2,4,null,null,5,null,null,3,
        6,null,null,7,null,null};
         //display(root2);
        HashSet<Integer> hashSet=new HashSet<>();
        int[] to_delete={3,5};
        for(int i: to_delete){
            hashSet.add(i);
        }
        Node root = construct(arr);
        List<Node> list=new ArrayList<>();
        Node root2=delNodes(root,hashSet,list);
        if(!hashSet.contains(root2.data)){
             list.add(root2); 
        }
        System.out.println(list.toString());
    }
    
    public static Node delNodes(Node root,HashSet<Integer> to_delete,List<Node> list) {
        if(root==null) return null;
        root.left=delNodes(root.left,to_delete,list);
        root.right=delNodes(root.right,to_delete,list);
        if(to_delete.contains(root.data)) {
            if(null!=root.left){
               list.add(root.left);  
            }
            if(null!=root.right){
               list.add(root.right);  
            }
            return null;
        }
        return root;
    }
}
