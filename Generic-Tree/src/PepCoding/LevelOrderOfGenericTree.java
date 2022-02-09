import java.util.*;
public class LevelOrderOfGenericTree {

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
		int[] data={10,20,-1,30,50,-1,60,-1,-1,40,-1};
		Node root=null;
		root=construct(data);
		levelOrder(root);
	}
	
	public static void levelOrder(Node root) {
		Queue<Node> queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node currNode=queue.remove();
			System.out.print(currNode.data+" ");
			for (Node child : currNode.children) {
                queue.add(child);
            }
		}
	}
}