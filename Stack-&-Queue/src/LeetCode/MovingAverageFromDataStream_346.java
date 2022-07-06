import java.util.*;
public class MovingAverageFromDataStream_346 {

	private int windoowSize=0;
	private double windowsSum=0;
	private Queue<Integer> queue=null;

	public MovingAverageFromDataStream_346(int size) {
        this.windoowSize=size;
		queue=new ArrayDeque<>();
    }
    
    public double next(int val) {
        queue.add(val);
		while(!queue.isEmpty() 
			&& queue.size() > windoowSize){
			windowsSum-=queue.remove();
		}
		windowsSum+=val;
		double average=windowsSum/Math.min(queue.size(),windoowSize);
		return average;
    }
	
	public static void main(String[] args){
		MovingAverageFromDataStream_346 movingAverage=new MovingAverageFromDataStream_346(3);
		System.out.println(movingAverage.next(1)); // return 1.0 = 1 / 1
		System.out.println(movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
		System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
		System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
	}
}