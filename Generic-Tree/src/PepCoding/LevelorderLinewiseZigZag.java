import java.util.*;
public class LevelorderLinewiseZigZag {
    
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
		int[] data={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=null;
		root=construct(data);
		levelOrder(root);
	}
    
	public static void levelOrder(Node node) {
		Stack<Node> ms = new Stack<>();
		ms.push(node);
		Stack<Node> cs = new Stack<>();
		int level = 0;
		while (ms.size() > 0) {
			node=ms.pop();
			System.out.print(node.data + " ");
			if (level%2 == 1) {
                for (int i = 0; i<node.children.size();i++) {
                    cs.push(node.children.get(i));
                }
            }
            else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    cs.push(node.children.get(i));
                }
            }
            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack< >();
                level++;
                System.out.println();
		    }
	    }	
	}
}