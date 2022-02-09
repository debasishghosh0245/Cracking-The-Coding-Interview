import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
public class ExclusiveTimeOfFunctions_636{

    
	public static void main(String[] args){
		int n = 2; 
		//String logs="0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7";
		//"0:start:0","0:start:1","0:start:2","0:end:3","0:end:4","0:end:5"
		// 5-2 // 3 //
		List<String> list=new ArrayList<>();
		list.add("0:start:0"); 
		list.add("0:start:1");
		list.add("0:start:2");
		list.add("1:end:3");  
		list.add("1:end:4");  
		list.add("0:end:5");
		int[] result=exclusiveTime(n,list);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] exclusiveTime(int n, List<String> logs) {
		Stack<Function> stack=new Stack<>();
		int[] result=new int[n];
		for(String log: logs){
			String[] logArr=log.split(":");
			if(!stack.isEmpty() && logArr[1].equals("end")) {
				 Function function=stack.pop();
				 int executionTime=(Integer.parseInt(logArr[2])-function.startTime+1)-
				 function.childExecutionTime;
				 System.out.println(executionTime);
				 result[function.id]+=executionTime;
				 if(!stack.isEmpty()){
					stack.peek().childExecutionTime+=executionTime+function.childExecutionTime;  
				 }
			}
			else{
				Function function=new Function();
				function.id=Integer.parseInt(logArr[0]);
				function.startTime=Integer.parseInt(logArr[2]);
				function.childExecutionTime=0;
				stack.push(function);
			}
		}
		return result;
    }

    public static class Function{
		 int id;
		 int startTime;
		 int childExecutionTime;
		 
		 public String toString(){
			 return id+" "+startTime+" "+childExecutionTime;
		 }
	}


}