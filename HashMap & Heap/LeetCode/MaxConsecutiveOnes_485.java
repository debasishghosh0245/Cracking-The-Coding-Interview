public class MaxConsecutiveOnes_485{

	public static void main(String[] args){
		int[] nums={1,1,0,1,1,1};
		System.out.println("Length >> "+findMaxConsecutiveOnes(nums));
	}

	public static int findMaxConsecutiveOnes(int[] nums){
		int length=0;
		int j=0;
		int count=0;
		for(int i=0;i<nums.length;i++){
			int num=nums[i];
			if(num==0){
				count++;
			}
			while(count>0){
				//release
				if(nums[j++]==0){
					count--;
				}
			}
			length=Math.max(length,(i-j)+1);
		}
		return length;
	}


}