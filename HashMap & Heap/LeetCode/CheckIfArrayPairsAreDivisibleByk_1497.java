public class CheckIfArrayPairsAreDivisibleByk_1497{

	public static void main(String[] args){
		/* int[] arr={91,74,66,48};
		int k =10; */
		int[] arr={-1,1,-2,2,-3,3,-4,4};
		int k=3;
		System.out.println(canArrange(arr,k));
	}
	
	public static boolean canArrange(int[] nums,int k) {
        HashMap<Integer,Integer> remainderFreq=new HashMap<>();
		for(int num:nums){
			int rem=num%k;
			if(rem<0) rem+=k;
			remainderFreq.put(rem,remainderFreq.getOrDefault(rem,0)+1);
		}
		System.out.println(remainderFreq);
		for(Map.Entry<Integer,Integer> entry:remainderFreq.entrySet()){
			int remainder=entry.getKey();
			if(remainder==0){
				int freq=remainderFreq.get(remainder);
				if(freq%2==1) return false;
			}
			else if(remainder*2==k){
				int freq=remainderFreq.get(remainder);
				if(freq%2==1) return false;
			}else{
				int freq1=remainderFreq.getOrDefault(remainder,0);
				int freq2=remainderFreq.getOrDefault(k-remainder,0);	
				if(freq1!=freq2) return false;
			}
		}
		return true;
    }


}