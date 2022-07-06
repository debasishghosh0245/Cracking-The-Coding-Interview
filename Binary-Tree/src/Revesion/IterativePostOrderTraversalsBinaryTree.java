import java.util.*;
public class IterativePostOrderTraversalsBinaryTree {

	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(TreeNode left, TreeNode right, int val) {
			this.left = left;
			this.right = right;
			this.val = val;
		}
	}

	public static int idx = 0;

	public static TreeNode consturctBT(Integer[] nums) {
		if (idx >= nums.length)
			return null;
		if (nums[idx] == null) {
			idx++;
			return null;
		}
		TreeNode root = new TreeNode(nums[idx++]);
		root.left = consturctBT(nums);
		root.right = consturctBT(nums);
		return root;
	}

	public static void display(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		display(root.left);
		display(root.right);
	}

	public static void printPreorder(TreeNode root) {
		Stack<Object[]> stack = new Stack<>();
		stack.push(new Object[] { root, 1 });
		//System.out.println(root.val);
		while (!stack.isEmpty()) {
			Object[] object = stack.peek();
			TreeNode node = ((TreeNode) object[0]);
			int state = (int) object[1];
			if (state == 1) {
				TreeNode left = node.left;
				if (null != left) {
					stack.push(new Object[] { left, 1 });
				} 
				object[1] = -1;
			} else if (state == -1) {
				TreeNode right = node.right;
				if (right != null) {
					stack.push(new Object[] { right, 1 });
				}
				object[1] = -2;
			} else if (state == -2) {
				System.out.println(((TreeNode)stack.pop()[0]).val);
			}
		}
	}

	public static void main(String[] args) {
		Integer[] nums = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
				null };
		TreeNode node = consturctBT(nums);
		printPreorder(node);

	}

}