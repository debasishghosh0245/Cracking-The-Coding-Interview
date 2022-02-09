import java.util.*;
public class RemoveAllAdjacentDuplicatesInStringII_1209 {
 
   /*  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/ */

    public static void main(String args[]){
		/* String str="pbbcggttciiippooaais";
		int k=2; */
		/* String str="abcd";
		int k=2; */
		/* String str= "pbbcggttciiippooaais";
        int k = 2; */
		String str="yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
		int k=4;
		System.out.println(removeDuplicates(str,k));
	}
   
    public static String removeDuplicates(String s, int k) {
		Stack<int[]> stack=new Stack<>();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!stack.isEmpty() && stack.peek()[1]==k) {
				stack.pop();
			}
			if(!stack.isEmpty() && stack.peek()[0]==ch){
				stack.peek()[1]+=1;
			}else{
			   stack.push(new int[]{ch,1});
			}
		}
		
		if(!stack.isEmpty() && stack.peek()[1]==k) {
				stack.pop();
		}
		
		for(int[] arr: stack) {
			 for(int i=0;i<arr[1];i++){
				  sb.append((char)arr[0]);
			 }
		}
		 return sb.toString();
	}
}
