import java.util.*;
public class SerializedAndDeserializedGenericTree {

	private static class Node{
		int data;
		List<Node> children=new ArrayList<Node>();
		Node(int data){
			this.data=data;
		}
	}
	
	public static void display(Node node){
		String str=node.data+"-->>";
		for(Node child:node.children){
			str=str+" "+child.data;
		}
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}
	
	public static void main(String[] args){
		int[] arr={10,20,-1,30,50,-1,60,-1,-1,40,-1};
		Node root=null;
		root=construct(root,arr);
		/* display(root); */
        StringBuilder data=new StringBuilder();
        serialized(root,data);
        System.out.println("Print Serialized Generic Tree >> "+data);
        String[] arr2=data.toString().split(" ");
        Node root2=deserialized(arr2);
        display(root2);
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

    private static String serialized(Node root,StringBuilder sb) {
        sb.append(root.data+" ");
        for(Node child: root.children) {
            serialized(child,sb);
        }
        sb.append("null ");
        return sb.toString();
    }

    private static Node deserialized(String[] arr) {
        Stack<Node> stack=new Stack<>();
        Node root=new Node(Integer.parseInt(arr[0]));
        stack.push(root);
        for(int i=1;i<arr.length;i++) {
            if(arr[i].equals("null")) {
               stack.pop();
            }else{
               Node newNode = new Node(Integer.parseInt(arr[i]));
               Node top=stack.peek();
               top.children.add(newNode); 
               stack.push(newNode);
            }
        }
        return root;
    }
}
