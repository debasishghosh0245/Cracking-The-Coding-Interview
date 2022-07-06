import java.util.*;
public class AsteroidCollision_735 {
	public static void main(String[] args){
		//int[] asteroids ={10,2,-5};
		int[] asteroids ={2,6,-8,-8,8,9};
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));
	}
	
	public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
		for(int i=0;i<asteroids.length;i++){
			if(asteroids[i]<0){
				while(!stack.isEmpty() && stack.peek() > 0 
				&& stack.peek() < Math.abs(asteroids[i])){
					stack.pop();
				}
				System.out.println("After poped >>"+stack);
				if(!stack.isEmpty() &&
					stack.peek()+asteroids[i]==0){
					stack.pop();
				}
				else if(!stack.isEmpty() && stack.peek() > Math.abs(asteroids[i])){
					//do nothing
				}else{
					stack.push(asteroids[i]);
				}
			}
			else {
				stack.push(asteroids[i]);
			}
			System.out.println(stack);
		}
		int[] answer=new int[stack.size()];
		int cnt=0;
		for(int asteroid: stack){
			answer[cnt++]=asteroid;
		}
		return answer;
    }
}