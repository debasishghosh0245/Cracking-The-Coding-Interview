import java.util.*;
public class VerticalOrderTraversalOfABinarytree {

	public static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val){
			this.val=val;
		}
		TreeNode(int val,TreeNode left,TreeNode right){
			this.val=val;
			this.left=left;
			this.right=right;
		}
	}
	
	static int idx=0;
	public static TreeNode construct(Integer[] nums){
		if(idx >=nums.length) return null;
		if(nums[idx]==null){
			idx++;
			return null;
		}
		TreeNode root=new TreeNode(nums[idx++]);
		root.left=construct(nums);
		root.right=construct(nums);
		return root;
	}
	
	public static void display(TreeNode root){
		if(root==null) return;
		System.out.print(root.val+" ");
		display(root.left);
		display(root.right);
	}
	
	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root){
		HashMap<Integer,ArrayList<Integer>> hashMap=new HashMap<>();
		ArrayList<ArrayList<Integer>> result=new ArrayList<>();
		Queue<Object[]> queue=new LinkedList<>();
		queue.offer(new Object[]{root,0});
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		while(!queue.isEmpty()){
			int size=queue.size();
			while(size-->0){
				Object[] objArr=queue.poll();
				TreeNode removed_node=(TreeNode)objArr[0];
				int removed_idx=(int)objArr[1];
				min=Math.min(removed_idx,min);
				max=Math.max(removed_idx,max);
				hashMap.putIfAbsent(removed_idx,new ArrayList<Integer>());
				hashMap.get(removed_idx).add(removed_node.val);
				if(removed_node.left!=null){
					queue.offer(new Object[]{removed_node.left,removed_idx-1});	
				}
				if(removed_node.right!=null){
					queue.offer(new Object[]{removed_node.right,removed_idx+1});
				}	
			}
		}
		for(int idx=min;idx<=max;idx++){
			result.add(hashMap.get(idx));
		}
		return result;
	}
	
	public static void main(String[] args){
		Integer[] nums={50,25,12,null,null,37,30,null,null,null,75,70,null,65,null,87,null,null};
		TreeNode node=construct(nums);
		//display(node);
		System.out.println(verticalOrderTraversal(node));
	}


}