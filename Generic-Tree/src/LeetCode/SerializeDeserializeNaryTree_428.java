import java.util.*;
public class SerializeDeserializeNaryTree_428 {

	private static class Node{
		int data;
		List<Node> children=new ArrayList<Node>();
		Node(int data){
			this.data=data;
		}
	}
	
	/** Size of Generic Tree **/ 
	public static int size(Node root){
		if(root==null) return 0;
		int sum=0;
		for(Node child: root.children){
			int cs=size(child);
			sum=sum+cs;
		}
		sum=sum+1;
		return sum;
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