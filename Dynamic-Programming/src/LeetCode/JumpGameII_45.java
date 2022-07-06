import java.util.*;
public class JumpGameII_45{
	

	
	public static void main(String[] args){
		int[] nums ={2,3,1,1,4};
		//int[] nums={2,3,0,1,4};
		jump(nums,0,0);
		//System.out.println(jump(nums));
	}	
	
	public static int jump(int[] nums) {
        int[] dp=new int[nums.length];
		dp[nums.length-1]=0;
		for(int i=nums.length-2;i>=0;i--){
			int minJump=Integer.MAX_VALUE;
			for(int jump=1;jump <= nums[i] && (i+jump)<nums.length; jump++){
				minJump=Math.min(dp[i+jump],minJump);
			}
			if(minJump!=Integer.MAX_VALUE){
				dp[i]=minJump+1;
			}else{
				dp[i]=minJump;
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[0];
    }
	
	
	public static void jump(int[] nums,int idx,int numOfJump){
		System.out.println("idx >> "+idx);
		if(idx==nums.length-1){
			System.out.println("Numbers Of Jumps >> "+numOfJump);
			return;
		}
		for(int jump=1;jump<=nums[idx];jump++){
			numOfJump=numOfJump+1;
			jump(nums,idx+jump,numOfJump);
			numOfJump=numOfJump-1;
		}
		
	}
}