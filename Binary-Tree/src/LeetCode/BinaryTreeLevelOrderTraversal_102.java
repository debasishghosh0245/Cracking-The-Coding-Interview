import java.util.*;
public class BinaryTreeLevelOrderTraversal_102 {
   
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
        Integer[]arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = construct(arr);
        display(root);
        List<List<Integer>> ans=levelOrder2(root);
        System.out.println(ans);
    }
    
    public static List<List<Integer>> levelOrder(Node root) {
        Queue<Node> mainQueue=new ArrayDeque<>();
        Queue<Node> childQueue=new ArrayDeque<>();
        List<List<Integer>> output=new ArrayList<List<Integer>>();
        mainQueue.add(root);
        List<Integer> newlist= new ArrayList<>();
        while(!mainQueue.isEmpty()) {
            Node currentNode=mainQueue.remove();
            newlist.add(currentNode.data);
            if(currentNode!=null && currentNode.left!=null){
                childQueue.add(currentNode.left);
            }
            if(currentNode!=null && currentNode.right!=null){
                childQueue.add(currentNode.right);
            }
            if(mainQueue.isEmpty()) {
                output.add(newlist);  
                newlist=new ArrayList<>();
                while(!childQueue.isEmpty()){
                    mainQueue.add(childQueue.remove());
                }
            }
        }
        return output;
    }
    
    public static List<List<Integer>> levelOrder2(Node root) {
        Queue<Node> mainQueue=new ArrayDeque<>();
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        mainQueue.add(root);
        mainQueue.add(new Node(-1));
        List<Integer> temp=new ArrayList<>();
        while(!mainQueue.isEmpty()) {
            Node currentNode=mainQueue.remove();
            if(currentNode.data!=-1) {
               temp.add(currentNode.data);
            }else{
                if(!mainQueue.isEmpty()) {
                   mainQueue.add(new Node(-1));
                   System.out.println("");
                   list.add(temp);
                   temp=new ArrayList<>();
                 
                }
            }
            if(currentNode!=null && currentNode.left!=null){
                mainQueue.add(currentNode.left);
            }
            if(currentNode!=null && currentNode.right!=null){
                mainQueue.add(currentNode.right);
            }
        }
        return list;
    }
}