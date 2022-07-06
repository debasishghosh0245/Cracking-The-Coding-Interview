import java.util.*;
public class BinaryTreeConstructor{
        
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
        Node root=new Node(arr[0],null,null);
        Pair pair=new Pair(root,1);
        Stack<Pair> stack=new Stack<>();
        stack.push(pair);
        int idx=0;
        while(!stack.isEmpty()) {
            Pair top=stack.peek();
            if (top.state==1) {
                idx++;
                if(null!=arr[idx]){
                    top.node.left=new Node(arr[idx],null,null);
                    Pair lp = new Pair(top.node.left,1);
                    stack.push(lp);                  
                }else{
                    top.node.left=null;
                }
                top.state++;
            }
            else if (top.state==2) {
                    idx++;
                    if(null!=arr[idx]){
                        top.node.right=new Node(arr[idx],null,null); 
                        Pair lp = new Pair(top.node.right,1);
                        stack.push(lp);   
                    }else{
                        top.node.right=null;
                    }
                    top.state++;
            }
            else if(top.state==3){
                    stack.pop();
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
        75,67,60,null,null,70,null,null,87,null,null};
        Node root = construct(arr);
        display(root);
    }
}