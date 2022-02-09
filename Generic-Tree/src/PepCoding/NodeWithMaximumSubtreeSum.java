import java.util.*;
public class NodeWithMaximumSubtreeSum {
	
	static int maxSum=Integer.MIN_VALUE;
	static int maxNode=0;
	
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
		for(int i=0;i<value.length;i++) {
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
		int[] data={10,20,-50,-1,60,-1,-1,30,-70,-1,80,-1,90,-1,-1,40,-100,-1,-1,-1};
		Node root=null;
		root=construct(data);
		maximumSubTreeSum(root);
		System.out.println(maxNode+"@"+maxSum);
	}
	
	public static int maximumSubTreeSum(Node root) {
	    int sum=0;
		if(root.children.size()==0) {
			return root.data;
		}
		for(Node child: root.children) {
			int csum=maximumSubTreeSum(child);
			sum+=csum;
		}
		sum+=root.data;
		if(sum>maxSum) {
			System.out.println("Node data >> "+root.data);
			maxSum=sum;
			maxNode=root.data;
		}
		return sum;
	}
	
}