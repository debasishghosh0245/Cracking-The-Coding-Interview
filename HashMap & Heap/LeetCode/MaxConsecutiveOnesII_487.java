public class  MaxConsecutiveOnesII_487{

	public static void main(String[] args){
		int[] nums={1,1,0,0,1,1};
		System.out.println("Length >> "+maxConsecutiveOnes(nums,1));
	}

	public static int maxConsecutiveOnes(int[] nums,int k){
		int length=0;
		int j=0;
		int count=0;
		for(int i=0;i<nums.length;i++) {
			int num=nums[i];
			if(num==0){
				count++;
			}
			while(count>k){
				int num1=nums[j++];
				if(num1==0) {
					count--;
				}
			}
			length=Math.max(length,(i-j)+1);
		}
		return length;
	}

}
