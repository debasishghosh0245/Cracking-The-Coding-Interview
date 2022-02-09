import java.util.Arrays;
import java.util.Stack;
public class DailyTemperatures_739{

    public static void main(String[] args) {
        int[] temperatures= {30,40,50,60};
        /* Output: [1,1,1,0]  */
       /* int[] temperatures = {73,74,75,71,69,72,76,73}; */
       /*  Output: [1,1,4,2,1,1,0,0] */       
       int[] result=dailyTemperatures(temperatures);
       System.out.println(Arrays.toString(result));
      
        
    }
    
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] output=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=temperatures.length-1;i>=0; i--){
             while(!stack.isEmpty() 
                   && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
             }
             if(stack.isEmpty()) {
                 output[i]=0;
             }else{
                 output[i]=stack.peek()-i;
             }
             stack.push(i);
        }
        
        return output;
    }

}