import java.util.*;
public class VerticalOrderSumOfBinaryTree{
    
    
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
        Integer[]arr = {50,25,12,null,null,37,30,null,null,40,null,null,
            75,67,60,null,null,70,null,null,87,null,null};
        Node root = construct(arr);
        //display(root);
        System.out.println(vertricalOrderSum(root,new ArrayList<Integer>()));
    }
    
    public static class PairCol{
        Node node;
        int column;
        PairCol(Node node,int column) {
            this.node=node;
            this.column=column;
        }
    }
    
    public static ArrayList<Integer> vertricalOrderSum(Node root,
        ArrayList<Integer> list){
        Queue<PairCol> queue=new ArrayDeque<>();
        PairCol pairCol=new PairCol(root,0);
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        queue.add(pairCol);
        int minColumn=0;
        int maxColumn=0;
        while(!queue.isEmpty()) {
             int size=queue.size();
             for(int i=0;i<size;i++) {
                  PairCol currPairCol=queue.remove();
                  int currentCol=currPairCol.column;
                  minColumn=Math.min(minColumn,currentCol);
                  maxColumn=Math.max(maxColumn,currentCol);
                  Node currentNode=currPairCol.node;
                  int sum=hashMap.getOrDefault(currentCol,0)
                  +currPairCol.node.data;
                  hashMap.put(currentCol,sum);
                  if(currentNode.left!=null) {
                        PairCol pairColleft=new PairCol(currentNode.left,currentCol-1);
                        queue.add(pairColleft);
                  }
                  if(currentNode.right!=null) {
                        PairCol pairColRight=new PairCol(currentNode.right,currentCol+1);
                        queue.add(pairColRight);
                  }
             }
        }
        for(int i=minColumn;i<=maxColumn;i++) {
            list.add(hashMap.get(i));
        }
        return list;
    }
    
}