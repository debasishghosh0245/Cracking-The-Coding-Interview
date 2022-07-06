import java.util.*;
public class KthLargestElementInTree {
        
    private static int state=0;
    private static int ceil=Integer.MAX_VALUE;
    private static int floor=Integer.MIN_VALUE;
    
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
		int[] arr={10,20,-50,-1,
        60,-1,-1,30,70,-1,-80,110,-1,-120,-1,-1,90 
        ,-1,-1,40,-100,-1,-1,-1};
		Node root=null;
		root=construct(root,arr);
		display(root);
        int k=8;
        int largest=Integer.MAX_VALUE;
        for(int i=0;i<k;i++) {
            floor=Integer.MIN_VALUE;
            largest=kthLargest(root,largest);
            System.out.println("Floor >> "+largest);
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
 
    public static int kthLargest(Node root,int key){
        if(root.data > key) {
           ceil=Math.min(root.data,ceil);
        }
        else if(root.data < key){
           floor=Math.max(root.data,floor);
        }
        for(Node child: root.children){
           kthLargest(child,key);
        }
        return floor;
    }
}
