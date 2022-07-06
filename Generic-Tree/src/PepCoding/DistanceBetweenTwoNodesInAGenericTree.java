import java.util.*;
public class DistanceBetweenTwoNodesInAGenericTree {

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
		int[] arr={10,20,50,-1,60,-1,-1, 
        30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,
        40,100,-1,-1,-1};
		Node root=null;
		root=construct(root,arr);
		display(root);
        System.out.println("distance "+distance(root,100,110));
        
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
    
    public static int distance(Node root,int data1,int data2){
        List<Integer> path1=nodeToRootPath(root,data1);
        System.out.println(path1);
        List<Integer> path2=nodeToRootPath(root,data2);
        System.out.println(path2);
        int i=path1.size()-1;
        int j=path2.size()-1;
        while(i>=0 && j>=0 && 
            path1.get(i)==path2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        int distance=i+j;
        return distance;
    }
    
    public static List<Integer> nodeToRootPath(Node root, int key) {
        List<Integer> path=new ArrayList<Integer>();
        if(root.data==key) {
           path.add(key);  
           return path;
        }
        for(Node node: root.children) {
           List<Integer> chPath=nodeToRootPath(node,key);
           if(chPath.size()>0){
              chPath.add(root.data);
              return chPath;
           }
        }
        return path;
    }
}
