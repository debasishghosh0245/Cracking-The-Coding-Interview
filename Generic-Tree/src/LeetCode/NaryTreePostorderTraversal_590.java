import java.util.*;
public class NaryTreePostorderTraversal_590 {
	
	private static class Node {
		private int data;
		private List<Node> children=new ArrayList<Node>();
        Node(int data){
			this.data=data;
		}
	}
	public static void display(Node root){
		System.out.print(root.data+"--->>");
		for(Node child: root.children) {
			System.out.print(child.data+"-");
		}
		System.out.println(".");
		for(Node child: root.children) {
			display(child);
		}
	}
	public static Node construct(int[] value) {
		Node root=null;
		Stack<Node> stack=new Stack<>();
		for(int i=0;i<value.length;i++){
			if(value[i]==-1 && !stack.isEmpty()) {
				stack.pop();
			}else{
				Node newNode=new Node(value[i]);
				if(stack.isEmpty()) {
					root=newNode;
				}
				else{
					stack.peek().children.add(newNode);
				}
				stack.push(newNode);
			}
		}
		return root;
	}
	public static void main(String[] args){
		int[] arr={10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
		Node root=null;
		root=construct(arr);
		List<Integer> list=printPostOrder(root);
        System.out.println(list);
	}
    
    public static class Pair {
        Node node;
        int state;
        Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
    }
    
    public static List<Integer> printPostOrder(Node root){
		List<Integer> postorder =new ArrayList<>();
        if(root==null) return postorder;
        Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, -1));
		
		while (!stack.isEmpty()) {
			int cstate = stack.peek().state;
			Node cnode = stack.peek().node;
			if (cstate == -1) {
				stack.peek().state++;
			} 
            else if (cstate == cnode.children.size()) {
				postorder.add(cnode.data);
				stack.pop();
			}
            else if (cstate >= 0 && cstate < cnode.children.size()) {
				stack.peek().state++;
				stack.push(new Pair(cnode.children.get(cstate), -1));
			}
		}
        return postorder;
    }
}