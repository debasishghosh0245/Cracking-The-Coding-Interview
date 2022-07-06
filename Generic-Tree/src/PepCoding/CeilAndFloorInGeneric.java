import java.util.*;
public class CeilAndFloorInGenericTree {

	 static int ceil;
	 static int floor;
	 static int state=0;
	
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
		int[] data={10,20,40,-1,50,-1,-1,30,60,-1,70,-1,-1};
		Node root=null;
		root=construct(data);
		display(root);
		predecessorAndSuccessor(root,50);
		System.out.println("ceil >> "+ceil);
		System.out.println("Floor >> "+floor);
	}
	
	
	public static void predecessorAndSuccessor(Node root,int value) {
		if(state==0) {
			if(root.data==value) {
				state=1;
			}else if(root.data<value){
				ceil=root.data;
			}
		}else if(state=1){
			if(root.data>value){
				floot=root.data;
			}
			state=2;
		}
		for(Node child: root.children) {
			predecessorAndSuccessor(child,value); 
		}
	}
}