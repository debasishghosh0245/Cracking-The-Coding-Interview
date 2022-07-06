import java.util.*;
public class FindBottomLeftTreeValue_513{

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
	
	public static int findBottomTopView(TreeNode root){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(root==null) return 0;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root); 
		int size=0;
		while(!queue.isEmpty()){
			size=queue.size();
			List<Integer> temp=new ArrayList<>();
			for(int i=0;i<size;i++){
				TreeNode rmNode=queue.poll();
				temp.add(rmNode.val);
				if(null!=rmNode && null!=rmNode.left){
					queue.offer(rmNode.left);
				}
				if(rmNode!=null && null!=rmNode.right){
					queue.offer(rmNode.right);
				}
			}
			result.add(temp);
		}
        List<Integer> list=result.get(result.size()-1);  
		return list.get(0);
	}
	
	public static void main(String[] args){
		Integer[] nums={50,25,12,null,null,37,30,null,null,null,75,70,null,65,null,87,null,null};
		TreeNode node=construct(nums);
		//display(node);
		System.out.println(findBottomTopView(node));
	}



}