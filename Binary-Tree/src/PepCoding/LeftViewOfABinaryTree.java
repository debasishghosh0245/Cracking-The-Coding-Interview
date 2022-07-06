import java.util.*;
public class LeftViewOfABinaryTree {
    
    public  static class Node {
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right) {
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    
    public static void display(Node root) {
        if(root==null) return ;
        System.out.print(root.left==null ? " - " : root.left.data +" ");
        System.out.print(root.data+" ");
        System.out.print(root.right==null ? " - " : root.right.data+" ");
        System.out.println("");
        display(root.left);
        display(root.right);
    }
    
    public static class Pair {
        int state;
        Node node;
        Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
        
    }
    
    public static Node construct(Integer[] arr) {
        Stack<Pair> stack=new Stack<>();
        Node root=new Node(arr[0],null,null);
        Pair pair=new Pair(root,1);
        stack.push(pair);
        int idx=0;
        while(!stack.isEmpty()){
            Pair top=stack.peek();
            if(top.state==1) {
                idx++;
                if(arr[idx]!=null) {
                  top.node.left=new Node(arr[idx],null,null);  
                  stack.push(new Pair(top.node.left,1));
                }
                top.state++;
            }
            else if(top.state==2) {
                idx++;
                if(null!=arr[idx]) {
                    top.node.right=new Node(arr[idx],null,null); 
                    stack.push(new Pair(top.node.right,1));                  
                }
                top.state++;
            }else{
                stack.pop();
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75,67,null,null,87,null,null};
        Node root=construct(arr);
        ArrayList<Integer> list=printLeftView(root);
        System.out.println(list);
    }
   
    public static ArrayList<Integer> printLeftView(Node root) {
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root); 
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            int level=queue.size(); //1
            list.add(queue.peek().data);
            for(int i=0;i<level;i++) {
                Node currentNode=queue.remove();
                if(null!=currentNode.left) {
                        queue.add(currentNode.left); 
                }
                if(null!=currentNode.right){
                        queue.add(currentNode.right);
                } 
            } 
        }
        return list;
    }
}