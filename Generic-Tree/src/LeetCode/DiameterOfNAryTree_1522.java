import java.util.*;
public class DiameterOfNAryTree_1522 {
    
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
		//int[] data={1,3,5,-1,6,-1,-1,2,-1,4};
        //int[] data={1,2,3,5,-1,-1,4,6};
        int[] data={3,1,5};
        //root = [1,null,3,2,4,null,5,6]
		Node root=null;
		root=construct(data);
        display(root);
        diameter(root);
        System.out.println("Print Diameter >> "+diameter);
	}
    
    public static int diameter(Node root) {
        int maxheight=-1;
        int secndmaxheight=-1;
        int height=-1;
        for(Node child: root.children) {
            height=diameter(child);
            if(height>maxheight) {
                secndmaxheight=maxheight;
                maxheight=height;
            }
            else if(height>secndmaxheight){
                secndmaxheight=height;
            }
            diameter=Math.max(maxheight+secndmaxheight+2,diameter);
            diameter(child);
        } 
        height=height+1;
        return height;
    }
    

}

