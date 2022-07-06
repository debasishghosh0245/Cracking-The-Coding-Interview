public class RecursivelyMuliply{
	
	public static void main(String[] args){
		System.out.println(pow(2,5));
	}
	
	public static int pow(int num,int base){
		int res=0;
		if(base==0) return 1;
		if(base==1) return num;
		if(base%2==0){
			res=pow(num,base/2); 
			res=res*res;
		}else{
			res=pow(num,base/2); 
			res=res*res*num;
		}
		return res;
	}
}
