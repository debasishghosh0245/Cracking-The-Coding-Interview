public class Pattern132_456{

	public static void main(String[] args){
		int[] nums={6,12,3,4,6,11,20};
		find132pattern(nums);
		
	}

	public boolean find132pattern(int[] nums) {
        for(int i=0;i<nums.length-2;i++){
			for(int j=i+1;j<nums.length-1;j++){
				for(int k=j+1;k<nums.length;k++){
					 if(nums[j] > nums[i] && nums[j] > nums[k] && nums[k] > nums[i]){
						 System.out.println("i"+i+"j"+j+"k"+k);
					 }
				}
			}
		}
		return false;
    }
}