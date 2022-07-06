import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
public class NextGreaterElement_496{
   
   public static void main(String args[]) {
       int[] nums2 = {1,3,4,2};
       int[] nums1 = {4,1,2};
       HashMap<Integer,Integer> ngrMap=getNextLargetRight(nums2);
       System.out.println(ngrMap.toString());
       int[] result=new int[nums1.length];
       for(int i=0;i<nums1.length;i++) {
           result[i]=ngrMap.get(nums1[i]);
       }
       System.out.println(Arrays.toString(result));
   
   }
   
   public static HashMap<Integer,Integer> getNextLargetRight(int[] arr) {
      HashMap<Integer,Integer> hashMap=new HashMap<>();
      Stack<Integer> stack=new Stack<Integer>();
      stack.push(-1);
      for(int i=arr.length-1;i>=0;i--) {
         while(!stack.isEmpty() && arr[i]>=stack.peek()) {
             stack.pop();
         }    
         if(stack.isEmpty()){
            hashMap.put(arr[i],-1);
         }
         else {
           hashMap.put(arr[i],stack.peek());           
         }
         stack.push(arr[i]);
      }
      return hashMap;
  }

}

