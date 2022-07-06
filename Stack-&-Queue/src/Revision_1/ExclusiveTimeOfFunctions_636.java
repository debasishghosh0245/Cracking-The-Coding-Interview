import java.util.*;
public class ExclusiveTimeOfFunctions_636  {
	
	public static void main(String[] args){
		int n=1; 
		String[] logs4={"0:start:0","0:start:1","0:start:2","0:end:3","0:end:4","0:end:5"};
		//String[] logs2={"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};
		//String[] logs3={"0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"};
		System.out.println(Arrays.toString(exclusiveTimeOfFunction(logs4,n)));
	}

	private static int[] exclusiveTimeOfFunction(String[] logs,int n) {
		Stack<FunctionDetails> stack=new Stack<FunctionDetails>();
		int[] result=new int[n];
		for(int i=0;i<logs.length;i++) {
			String[] logsParts=logs[i].split(":");
			if(logsParts[1].equals("end")){
				FunctionDetails functionDetails=stack.pop();
				functionDetails.executionTime=(Integer.parseInt(logsParts[2])-
				functionDetails.executionTime+1)-functionDetails.childExcutionTime;
				result[functionDetails.functionId]+=functionDetails.executionTime;
				if(!stack.isEmpty()){
					FunctionDetails parentFun=stack.peek();
					parentFun.childExcutionTime+=functionDetails.executionTime+functionDetails.childExcutionTime;
				}
				
			}else {
				FunctionDetails functionDetails=new FunctionDetails();
				functionDetails.functionId=Integer.parseInt(logsParts[0]);
				functionDetails.executionTime=Integer.parseInt(logsParts[2]);
				stack.push(functionDetails);
			}
		}
		System.out.println(Arrays.toString(result));
		return result;
	}
	
	public static class FunctionDetails {
		int functionId;
		int executionTime;
		int childExcutionTime;
		FunctionDetails(){ }
		//@Override
		public String toString(){ 
		  return ""+this.executionTime+" "+this.functionId+" "+this.childExcutionTime;	
		}
	}
	
}