import java.util.*;
public class AvoidFloodInTheCity_1488{
	
	public static void main(String[] args){
		int[] rains={1,2,0,0,2,1};
		System.out.println(Arrays.toString(avoidFlood(rains)));
	}
	
	public static int[] avoidFlood(int[] rains) {
		int[] result=new int[rains.length];
        HashMap<Integer,Integer> map=new HashMap<>();
		TreeSet<Integer> set=new TreeSet<>();
		for(int i=0;i<rains.length;i++){
			int lake=rains[i];
			if(lake==0){
				set.add(i);
				result[i]=1;
			}else{
				if(map.containsKey(lake)){
					int day=map.get(lake);
					Integer higherDay=set.higher(day);
					if(higherDay==null){
					   return new int[0];
					}
					set.remove(higherDay);
					result[higherDay]=lake;
				}
				map.put(lake,i);
				result[i]=-1;
			}
		}
		return result;
    }


}