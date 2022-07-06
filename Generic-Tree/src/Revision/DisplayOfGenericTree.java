public class DisplayOfGenericTree{
		public static class TreeNode {
		int data;
		ArrayList<TreeNode> children=new ArrayList<>(); 
		TreeNode(){}
		TreeNode(int data){
			this.data=data;
		}
	}
	
	public static void display(TreeNode root) {
		System.out.print(root.data+" -> ");
		for(TreeNode child: root.children){
			System.out.print(child.data+" ");
		}
		System.out.println();
		for(TreeNode child : root.children){
			display(child);
		}
	}
	
	public static TreeNode construct(int[] arr){
		TreeNode root = null;
        Stack<TreeNode> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
			st.pop();
		} else {
			TreeNode t = new TreeNode();
			t.data = arr[i];

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
		int[] arr={10,20,-1,30,50,-1,60,-1,-1,40,-1};
		TreeNode node=construct(arr);
		display(node);
			
	}

}