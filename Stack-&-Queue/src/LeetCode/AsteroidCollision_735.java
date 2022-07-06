import java.util.Arrays;
import java.util.Stack;
public class AsteroidCollision_735 {
    
	public static void main(String[] args){
	    //int[] asteroids = {10,2,-5};
		//int[] asteroids={8,-8}; 
		//int[] asteroids={5,10,-5};
		//int[] asteroids={-2,-2,2,-2};
		int[] asteroids={-2,-2,1,-2};
		int[] result=asteroidCollision(asteroids);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<asteroids.length;i++) {
			if(asteroids[i] < 0){

				while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]){
					stack.pop();
				}
				if(!stack.isEmpty() && stack.peek() == -asteroids[i] ){
					stack.pop();
				}
				else if(!stack.isEmpty() && stack.peek() >  -asteroids[i] ){
					//
				}else{
					stack.push(asteroids[i]);
				}

			}else{
				stack.push(asteroids[i]);
			}
		}
		int[] result=new int[stack.size()];;
		if(!stack.isEmpty()) {

			for(int r=result.length-1;r>=0;r--) {
				result[r]=stack.pop();
			}
		}
		return result;
    }
   

}