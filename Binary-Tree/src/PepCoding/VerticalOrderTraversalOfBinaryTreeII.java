import java.util.*;
public class VerticalOrderTraversalOfBinaryTreeII{
    
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
        //Integer[]arr = {100,25,12,null,null,67,30,null,null,40,null,null,
        //75,37,null,null,87,null,null};
        Integer[]arr = {2,7,2,null,null,6,5,null,null,11,null,null,5,null,9,4,null,null,null};
        Node root = construct(arr);
        System.out.println(vertricalOrderTraversal(root));
    }
    
    public static class PairCol implements Comparable {
        Node node;
        int column;
        PairCol(Node node,int column) {
            this.node=node;
            this.column=column;
        }
        public int compareTo(Object obj) {
            PairCol paircol=(PairCol)obj;
            if(paircol.node.data==this.node.data){
                return 0;
            }
            else if(paircol.node.data > this.node.data) {
                return -1;
            }else{
                return 1;
            }
        }
    }
    
    public static List<List<Integer>> vertricalOrderTraversal(Node root) {
        PriorityQueue<PairCol> mainQueue=new PriorityQueue<>();
        PriorityQueue<PairCol> childQueue=new PriorityQueue<>();
        mainQueue.add(new PairCol(root,0)); 
        HashMap<Integer,ArrayList<Integer>> columnTable=new HashMap<>();
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        int minColumn=0;
        int maxColumn=0;
        while(!mainQueue.isEmpty()) {
            int size=mainQueue.size();
            for(int i=0;i<size;i++) {
                PairCol currentNode=mainQueue.remove();
                columnTable.putIfAbsent(currentNode.column,new ArrayList<>());
                if(null!=currentNode.node){
                    columnTable.get(currentNode.column).add(currentNode.node.data); 
                }
                minColumn=Math.min(currentNode.column,minColumn);
                maxColumn=Math.max(currentNode.column,maxColumn);
                if(null!=currentNode.node.left){
                    childQueue.add(new PairCol(currentNode.node.left,currentNode.column-1)); 
                }
                if(null!=currentNode.node.right) {
                    childQueue.add(new PairCol(currentNode.node.right,currentNode.column+1));   
                }
                if(mainQueue.isEmpty()){
                    while(!childQueue.isEmpty()) {
                       mainQueue.add(childQueue.remove()); 
                    }
                }
            }
        }
        for(int i=minColumn;i<=maxColumn;i++) {
           list.add(columnTable.get(i));
        }
        return list;
    }
}