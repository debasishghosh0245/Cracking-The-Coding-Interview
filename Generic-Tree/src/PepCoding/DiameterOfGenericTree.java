import java.util.*;
public class DiameterOfGenericTree {
	
	static int secmaxheight=-1;
	static int diameter=0;
	
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
		//int[] data={10,20,-1,30,40,50,-1,-1,-1,60,70,-1,-1};
		int[] data={10,-20,-1,30,-50,-1,60,-1,-1,40,-1,-1};
		Node root=null;
		root=construct(data);
		System.out.println("Maximum Height---      >> "+calDiameter(root));
		System.out.println("Second Max Height----  >> "+secmaxheight);
		System.out.println("Diameter ----  >> "+diameter);
	}
	
	public static int calDiameter(Node root) {
		int maxheight=-1;
		for(Node child : root.children){
			int crrheight=calDiameter(child); 
			if(crrheight>maxheight){
				secmaxheight=maxheight;
				maxheight=crrheight;
			}else if(crrheight>secmaxheight) {
				secmaxheight=crrheight;
			}
		}
		if(maxheight+secmaxheight+2 > diameter) {
			diameter=maxheight+secmaxheight+2;	
		}
		maxheight=maxheight+1;
		return maxheight;
	}
}