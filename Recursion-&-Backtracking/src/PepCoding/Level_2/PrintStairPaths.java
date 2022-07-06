import java.util.*;
public class PrintStairPaths{

	public static void main(String[] args){
		getStairPath(3,new ArrayList<Integer>());
	}
	
	public static void getStairPath(int n,List<Integer> path){
		if(n==0){
			System.out.println(path);
			return;
		}
		if(n-1>=0){
			path.add(1);
			getStairPath(n-1,path);
			path.remove(path.size()-1);
		}
		if(n-2>=0){
			path.add(2);
			getStairPath(n-2,path);
			path.remove(path.size()-1);
		}
		if(n-3>=0){
			path.add(3);
			getStairPath(n-3,path);
			path.remove(path.size()-1);
		}
	}
}