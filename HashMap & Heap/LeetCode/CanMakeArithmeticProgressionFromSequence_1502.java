import java.util.*;
public class CanMakeArithmeticProgressionFromSequence_1502{

	public static void main(String[] args){
		/* int[] arr ={1,2,4}; */
		int[] arr={0,0,0,0};
		System.out.println(canMakeArithmeticProgression(arr));
	}
	
	public static boolean canMakeArithmeticProgression(int[] arr) {
        int max=arr[0],min=arr[0]; int length=arr.length;
		HashSet<Integer> set=new HashSet<>();
		for(int i:arr){
			max=Math.max(i,max);
			min=Math.min(i,min);
			set.add(i);
		}
		int divident=max-min;
		int divisor=length-1;
		if(divisor>divident) return true;
		int commonDiff=(max-min)/(length-1);
		
		for(int i=min;i<=max;i=i+commonDiff){
			if(!set.contains(i)) return false;
		}
		return true;
    }
}
