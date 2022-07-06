import java.util.*;
public class UniqueBinarySearchTrees2 {
      
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(){};
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        Node(int data) {
            this.data=data;
        }
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
        List<Node> ans=generateTrees(1,3);
        for(int i=0;i<ans.size();i++){
            display(ans.get(i));
            System.out.printl("-----------");
        }
    }
    
    public static List<Node> generateTrees(int start,int end) {
        Node root = null;
		if (start > end) {
			List<Node> list = new ArrayList<Node>();
			list.add(null);
			return list;
		}
		List<Node> ans = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			List<Node> left = generateTrees(start, i - 1);
			List<Node> right = generateTrees(i + 1, end);
			for (Node l : left) {
				for (Node r : right) {
					root = new Node(i);
					root.left = l;
					root.right = r;
					ans.add(root);
				}
			}
		}
		return ans;
    }
}
