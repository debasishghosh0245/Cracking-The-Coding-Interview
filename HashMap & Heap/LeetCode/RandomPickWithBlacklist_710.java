import java.util.*;
public class RandomPickWithBlacklist_710 {
	
	public static void main(String[] args){
		int[] blacklist={2,3,5};
    	Solution solution = new Solution(7,blacklist); 
		System.out.println(solution.pick()); 
    	System.out.println(solution.pick()); // return 1
    	System.out.println(solution.pick()); // return 6
    	System.out.println(solution.pick()); // return 1
    	System.out.println(solution.pick()); // return 0
    	System.out.println(solution.pick()); // return 4 */
	}
}

class Solution {
	
	Random ran=new Random();
	HashMap<Integer,Integer> backlistMap=new HashMap<Integer,Integer>();
	int range;
    public Solution(int n, int[] blacklist) {
		range=n-blacklist.length;
		HashSet<Integer> backlistSet=new HashSet<>();
		for(int num:blacklist){
			backlistSet.add(num);
		}
		n--;
		for(int num:blacklist){
			if(num<range){
				
				while(backlistSet.contains(n)){
					n--;
				}
				backlistMap.put(num,n);
				n--;
			}
		}
		System.out.println(backlistMap);
    }
    
    public int pick() {
		int picked=ran.nextInt(range);
		if(backlistMap.containsKey(picked)){
			return backlistMap.get(picked);
		}else{
			return picked;
		}
    }
}

//Memory Limit Exceed //
class Solution1 {
	
	ArrayList<Integer> whiteList=new ArrayList<>();
	HashSet<Integer> set=new HashSet<>();
	Random ran=new Random();
	
    public Solution1(int n, int[] blacklist) {
        for(int i=0;i<n;i++){
			set.add(i);
		}
		for(int i:blacklist){
			set.remove(i);
		}
		for(int i:set){
			whiteList.add(i);
		}
		System.out.println(whiteList);
    }
    
    public int pick() {
        return whiteList.get(ran.nextInt(whiteList.size()));
    }
}
