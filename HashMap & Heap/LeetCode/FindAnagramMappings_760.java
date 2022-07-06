import java.util.*;
public class FindAnagramMappings_760 {

	public static void main(String[] args) {
		int[] nums1={1,2,3,4,5,2};
		int[] nums2={4,3,2,1,5,2};
		int[] output=anagramMappings(nums1,nums2);
		System.out.println(Arrays.toString(output));
	}
	
	public static class Pair {
		int idx=0;
		List<Integer> indexList=new ArrayList<>();
		public String toSring(){
			return idx+"  "+indexList;
		}
	}
	
	public static int[] anagramMappings(int[] nums1, int[] nums2) {
		HashMap<Integer,Pair> hashMap=new HashMap<Integer,Pair>();
		int[] result=new int[nums1.length];
		int j=0;
		for(int i=0;i<nums2.length;i++){
			int num=nums2[i];
			if(hashMap.get(num)==null){
				Pair pair=new Pair();
				List<Integer> list=new ArrayList<>();
				list.add(i);
				pair.indexList=list;
				hashMap.put(num,pair);
			}else{
				Pair pair=hashMap.get(num);
				pair.indexList.add(i);
				hashMap.put(num,pair);
			}
		}
		for(int i=0;i<nums1.length;i++){
			int num=nums1[i];
			Pair pair=hashMap.get(num);
			int idx=pair.idx;
			int res=pair.indexList.get(idx);
			pair.idx++;
			result[j++]=res;
		}		
		return result;
	}
}