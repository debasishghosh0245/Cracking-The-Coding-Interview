import java.util.*;
public class BinaryTreeVerticalOrderTraversal_314{
	public static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		TreeNode(int val){
			this.val=val;
		}
		TreeNode(TreeNode left,TreeNode right,int val){
			this.left=left;
			this.right=right;
			this.val=val;
		}
	}
	
	private static int idx;
	public static TreeNode construct(Integer[] nums){
		if(idx > nums.length-1) return null;
		if(null==nums[idx]){
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
		StringBuilder sb=new StringBuilder();
		if(root!=null && root.left!=null ){
			sb.append(root.left.val);
		}else{
			sb.append("-");
		}
			sb.append(" <- "+root.val+" -> ");
		if(root!=null && root.right!=null){
			sb.append(root.right.val);
		}
		else{
			sb.append(" - ");
		}
		System.out.println(sb);
		display(root.left);
		display(root.right);
	}
	
	//TreeMap 
	//Time Complexity: Extra sorting time nLogn
	public static List<List<Integer>> verticalOrder(TreeNode root){
		Queue<Object[]> queue=new LinkedList<>();
		//TreeMap<Integer,List<Integer>> map=new TreeMap<>();
		HashMap<Integer,List<Integer>> map=new HashMap<>();
		List<List<Integer>> result=new ArrayList<>();
		queue.offer(new Object[]{root,0});
		int min_idx=Integer.MAX_VALUE;
		int max_idx=Integer.MIN_VALUE;
		while(!queue.isEmpty()){
			int size=queue.size();
			while(size-->0){
				size--;
				Object[] removedObj=queue.poll();
				int removed_idx=(int)removedObj[1];
				
				min_idx=Math.min(min_idx,removed_idx);
				max_idx=Math.max(max_idx,removed_idx);
				
				TreeNode removed_node=(TreeNode)removedObj[0];
				if(!map.containsKey(removed_idx)){
					List<Integer> list=new ArrayList<>();
					list.add(removed_node.val);
					map.put(removed_idx,list);
				}
				else{
					List<Integer> list=map.get(removed_idx);
					list.add(removed_node.val);
					map.put(removed_idx,list);
				}
				if(removed_node.left!=null){
					queue.offer(new Object[]{removed_node.left,removed_idx-1});
				}
				if(removed_node.right!=null){
					queue.offer(new Object[]{removed_node.right,removed_idx+1});
				}
			}
		}
		//System.out.println(min_idx);
		//System.out.println(max_idx);
		/* for(List<Integer> entry: map.values()){
			result.add(entry);
		} */
		for(int key=min_idx;key<=max_idx;key++){
			result.add(map.get(key));
		}
		//System.out.println(map);
		return result;
	}
	
	public static void main(String[] args){
		Integer[] root={3,9,20,null,null,15,7};
		TreeNode treeNode=construct(root);
		System.out.println(verticalOrder(treeNode));
	}

}