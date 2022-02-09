public class CoinChangePermutations2{
	
	public static void main(String[] args){
		int[] nums={1,2,3,4};
		boolean[] used=new boolean[nums.length];
		permutaion(nums,0,used,5,0,"");
	}
	
	public static void permutaion(int[] nums,int idx,boolean[] used,int target,
		int targetsf,String ansf){
		if(targetsf==target) {
			System.out.println(ansf+" >> "+targetsf);
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(used[i]==false) {
				used[i]=true;
				permutaion(nums,idx+1,used,target,targetsf+nums[i],ansf+nums[i]);
				used[i]=false;
			}
		}
	}
}