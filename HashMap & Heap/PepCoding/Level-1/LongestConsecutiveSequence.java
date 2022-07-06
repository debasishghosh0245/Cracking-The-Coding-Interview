import java.util.*;
public class LongestConsecutiveSequence{

	public static void main(String[] args){
		int[] nums={10,5,9,1,11,8,6,15,3,12,2};
		longestConsecutive(nums);
	}
	
	//Time Complexity   : O(n)
	//Space Complexcity : O(n)
	public static void longestConsecutive(int[] nums) {
		//base case
		if(nums.length==0) return 0;
        HashMap<Integer,Boolean> hashMap=new HashMap<>();
		for(int num:nums){
			hashMap.put(num,true);
		}
		int maxSeqLngth=1;
		int startingSeq=0;
		for(Map.Entry<Integer,Boolean> entry:hashMap.entrySet()){
			if(!hashMap.containsKey(entry.getKey()-1)){
				int currSeq=entry.getKey();
				int tempSeq=currSeq;
				int currSeqLngth=1;
				while(hashMap.containsKey(tempSeq+1)){
					 currSeqLngth++;
					 tempSeq++;
				}
				if(currSeqLngth>maxSeqLngth){
					maxSeqLngth=currSeqLngth;
					startingSeq=currSeq;
				}
			}
		}
		for(int i=startingSeq;i< maxSeqLngth+startingSeq;i++){
			System.out.println(i);
		}
    }
}