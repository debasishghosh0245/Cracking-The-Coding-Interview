import java.util.*;
public class MaximumInAGenericTree {
	
	private static class Node{
		int data;
		List<Node> children=new ArrayList<Node>();
		Node(int data){
			this.data=data;
		}
	}
	public static Node construct(Node root,int[] arr) {
		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node t = new Node(arr[i]);
				if (st.size() > 0) {
					st.peek().children.add(t);
				} else {
					root = t;
				}
				st.push(t);
			}
		}
		return root;
	}
	public static void main(String[] args){
		int[] arr={10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
		Node root=null;
		root=construct(root,arr);
		System.out.println("Size >> "+max(root));
	}
	
	// maximum of a generic tree //
	public static int max(Node root){
		if(root.children.size()==0) {
			return root.data;
		}
		int max=0;
		for(Node child: root.children){
			int cmax=max(child);
			max=Math.max(cmax,max);
		}
		max=Math.max(max,root.data);
		return max;
	}

}