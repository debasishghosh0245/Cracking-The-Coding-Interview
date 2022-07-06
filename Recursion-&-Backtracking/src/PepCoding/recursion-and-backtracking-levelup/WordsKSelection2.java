import java.util.*;
public class WordsKSelection2{
	
	
	public static void main(String[] args) {
		String str="abcde";
		String[] place=new String[str.length()];
		permutaion(str,place,0,0);
	}
	
	public static void permutaion(String str,String[] place,int last,int cs) {
		if(cs==3){
			for(String  ans: place){
				if(ans!=null){
					System.out.print(ans);
				}
			}
			System.out.println("");
			return;
		}
		for(int i=last;i<place.length;i++){
				if(place[i]==null) {
					char ch=str.charAt(i);
					place[i]=ch+"";
					permutaion(str,place,i,cs+1);
					place[i]=null;
				}
		}
	}
}