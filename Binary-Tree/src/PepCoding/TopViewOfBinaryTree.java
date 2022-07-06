import java.util.*;
public class TopViewOfBinaryTree{
    
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
        Integer[]arr = {50,25,12,null,null,67,60,null,null,40,null,null,
        75,37,30,null,null,70,null,null,87,null,null};
        Node root = construct(arr);
        System.out.println(botttomView(root));
    }
    
    public static class PairCol{
        Node node;
        int column;
        PairCol(Node node,int column) {
            this.node=node;
            this.column=column;
        }
    }
    
    public static List<Integer> botttomView(Node root) {
        Queue<PairCol> queue=new ArrayDeque<>();
        queue.add(new PairCol(root,0)); 
        HashMap<Integer,Integer> columnTable=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        int minColumn=0;
        int maxColumn=0;
        while(!queue.isEmpty()) {
            int size=queue.size();
            for(int i=0;i<size;i++) {
                PairCol currentNode=queue.remove();
                if(null!=currentNode.node){
                   if(!columnTable.containsKey(currentNode.column)){
                        columnTable.put(currentNode.column,currentNode.node.data); 
                   }
                }
                minColumn=Math.min(currentNode.column,minColumn);
                maxColumn=Math.max(currentNode.column,maxColumn);
                if(null!=currentNode.node.left){
                    queue.add(new PairCol(currentNode.node.left,currentNode.column-1)); 
                }
                if(null!=currentNode.node.right) {
                    queue.add(new PairCol(currentNode.node.right,currentNode.column+1));   
                } 
            }
        }
        for(int i=minColumn;i<=maxColumn;i++) {
           list.add(columnTable.get(i));
        }
        return list;
    }
}