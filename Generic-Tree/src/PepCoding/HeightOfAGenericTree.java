import java.util.*;
public class HeightOfAGenericTree {
	
	private static class Node{
		int data;
		List<Node> children=new ArrayList<Node>();
		Node(int data){
			this.data=data;
		}
	}
	
	/** Height of Generic Tree :: Start  **/
	public static int height(Node root){
		if(root.children.size()==0) {
			return 0;
		}
		int height=-1;
		for(Node child: root.children){
			int cheight=height(child);
			height=Math.max(cheight,height);
		}
			height=height+1;
		return height;
	}
	/** Height of Generic Tree :: End  **/
	
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
		System.out.println("Size >> "+height(root));
	}

}