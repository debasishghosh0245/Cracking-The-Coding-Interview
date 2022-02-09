import java.util.*;
public class LevelOrderTravsal {

	private static class Node{
		int data;
		List<Node> children=new ArrayList<Node>();
		Node(int data){
			this.data=data;
		}
	}

	public static void main(String[] args){
		int[] arr={10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
		Node root=null;
		root=construct(root,arr);
		levelOrderTravesal(root);
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

	public static void levelOrderTravesal(Node root){
		if(root.children.size()==0) {
			System.out.println("Node Pre >> "+root.data);
			return;
		}
		System.out.println("Node Pre >> "+root.data);
		for(Node child:root.children) {
			levelOrderTravesal(child);
		}
	}
}
