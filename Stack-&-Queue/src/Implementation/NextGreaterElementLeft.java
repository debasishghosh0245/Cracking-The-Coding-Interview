import java.util.Arrays;
import java.util.Stack;
public class NextGreaterElementLeft {
  
  public static void main(String[] args) {
      /* int[] arr={1,3,2,4}; */
      int[] arr={1,3,0,0,1,2,4};
      int[] output=getNextLargetRight(arr);
      System.out.println(Arrays.toString(output));
      
  }
  
  public static int[] getNextLargetRight(int[] arr) {
      int[] nlr=new int[arr.length];
      Stack<Integer> stack=new Stack<Integer>();
      stack.push(-1);
      for(int i=0;i<arr.length;i++) {
         while(!stack.isEmpty() && arr[i]>=stack.peek()) {
             stack.pop();
         }    
         if(stack.isEmpty()){
             nlr[i]=-1;
         }
         else {
              nlr[i]=stack.peek();
         }
         stack.push(arr[i]);
      }
      return nlr;
  }
  
}
