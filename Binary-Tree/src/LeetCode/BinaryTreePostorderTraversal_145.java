import java.util.*;
public class BinaryTreePostorderTraversal_145 {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    public static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
       }
    }
    
    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
                top.node.left = new Node(arr[idx], null, null);
                Pair lp = new Pair(top.node.left, 1);
            st.push(lp);
            } else {
                top.node.left = null;
            }
            top.state++;
        } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
                top.node.right = new Node(arr[idx], null, null);
                Pair rp = new Pair(top.node.right, 1);
                st.push(rp);
            } else {
                top.node.right = null;
            }
            top.state++;
        } else {
            st.pop();
        }
    }
        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) throws Exception {
        Integer[]arr = {50,25,12,null,null,37,null,null,75,62,null,null,87,null,null};
        Node root = construct(arr);
        List<Integer> list=printPostOrder(root);
        System.out.println(list);
    }

    public static List<Integer> printPostOrder(Node root){
        List<Integer> preorder=new ArrayList<>();
        List<Integer> inorder=new ArrayList<>();
		List<Integer> postorder=new ArrayList<>();
        if(root==null) return postorder;
        
        Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, 1));
		
		while (!stack.isEmpty()) {
			int cstate = stack.peek().state;
			Node cnode = stack.peek().node;
			if(cstate == 1) {
                preorder.add(cnode.data);
				stack.peek().state++;
                if(null!=cnode.left){
                     stack.push(new Pair(cnode.left,1));
                }
			} 
            else if (cstate == 2) {
                inorder.add(cnode.data);
                stack.peek().state++;
                if(null!=cnode.right){
                    stack.push(new Pair(cnode.right,1));
                }
			} 
            else if (cstate==3) {
                postorder.add(cnode.data);
				stack.pop();
			}
		}
        return postorder;
    }
}
