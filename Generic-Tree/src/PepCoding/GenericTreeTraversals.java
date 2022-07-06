public class GenericTreeTraversals {
	
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
		printTravesal(root);
	}

	/** Trees node travelsal pre-order and post-order travsal :: start  */
	public static void printTravesal(Node root){
		if(root.children.size()==0) {
			return;
		}
		System.out.println("Node Pre >> "+root.data);
		for(Node child:root.children) {
				System.out.println("Edge Pre >> "+root.data+"-"+child.data);
				printTravesal(child);
				System.out.println("Edge Post >> "+root.data+"-"+child.data);
		}
		System.out.println("Node Post >> "+root.data);
	/** Trees node travelsal pre-order and post-order travsal :: start **/
	}
}