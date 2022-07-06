public class KthLargestElementGenericTree {
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
		mirror(root);
		System.out.println("Print Mirror");
		display(root);
	}


}