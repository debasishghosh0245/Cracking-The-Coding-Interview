public class TwoKeysKeyboard_650{

	public static void main(String[] args){
		int n=3;
		System.out.println(minSteps("A","AAA",1));
	}
	
	public static int minSteps(String ansSoFar,String result,int step) {
		if(ansSoFar.equals(result)) return 0;
		if(step >= 100) return step;
		int step_copy=0;
		int step_paste=0;
		System.out.println(ansSoFar);
		for(int i=0;i<=2;i++){
			step_copy=minSteps(ansSoFar,result,step+1);
			step_paste=minSteps(ansSoFar+"A",result,step+1);
		}
		return step_copy+step_paste;
	}

}