import java.util.*;
public class NaryTreeLevelOrderTraversal429 {

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
		int[] data={10,20,-1,30,50,-1,60,-1,-1,40,-1};
		Node root=null;
		root=construct(data);
		List<List<Integer>> list=levelOrder(root);
        System.out.println(list);
		
	}
	
	public static List<List<Integer>> levelOrder(Node root) {
		Queue<Node> mainQueue=new ArrayDeque<>();
		Queue<Node> childQueue=new ArrayDeque<>();
        List<List<Integer>> list=new ArrayList<List<Integer>>();
		List<Integer> temp=new ArrayList<>();
        mainQueue.add(root);
		while(!mainQueue.isEmpty()) {
			Node currNode=mainQueue.remove();
            temp.add(currNode.data);
			for (Node child : currNode.children) {
				childQueue.add(child);
			}
			if(mainQueue.isEmpty()) {
                list.add(temp);
                temp=new ArrayList<>();
				while(!childQueue.isEmpty()) {
                    mainQueue.add(childQueue.remove());
				}
			}
		}
        return list;
	}
    
    /** Count Approach :: start **/ 
    public static void  LevelOrderTraversal3(Node root) {
        Queue<Node> mainQueue=new ArrayDeque<>();
        mainQueue.add(root);
        
        while(!mainQueue.isEmpty()) {
            int level=mainQueue.size();
            for(int i=0;i<level;i++) {
                Node currentNode=mainQueue.remove();
                System.out.print(currentNode.data+" ");
                for(Node child: currentNode.children){
                      mainQueue.add(child);
                }
            } 
            System.out.println("");
        }
    } 
    /** Count Approach :: End **/ 
}