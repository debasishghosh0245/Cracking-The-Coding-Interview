import java.util.*;
public class AreTreesSimilarInShape {
	
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
		int[] data1={10,20,40,-1,50,-1,-1,30,60,-1,70,-1,-1};
		int[] data2={100,200,400,-1,500,-1,-1,300,606,-1,700,-1,-1};
		Node root1=null;
		root1=construct(data1);
		Node root2=null;
		root2=construct(data2);
		System.out.println("===========Display Tree One========");
		display(root1);
		System.out.println("===========Display Tree Two=========");
		System.out.println("Are Trees Similer >> "+areTreesSimiler(root1,root2));
		
	}
	
	public static boolean areTreesSimiler(Node root1,Node root2) {
		if(root1.children.size()!=root2.children.size()) {
			return false;
		}
		for(int i=0;i<root1.children.size();i++) {
			Node c1=root1.children.get(i);
			Node c2=root2.children.get(i);
			if(areTreesSimiler(c1,c2)==false) {
				return false;
			}
		}
		return true;
	}
}