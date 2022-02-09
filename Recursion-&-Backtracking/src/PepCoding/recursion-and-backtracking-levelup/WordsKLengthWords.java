public class WordsKLengthWords{

	public static void main(String[] args) {
		String str="abcde";
		String[] place=new String[str.length()];
		printPermutaion(str,place,0,3);
	}
	
	public static void printPermutaion(String str,String[] place,int cs,int ts) {
		if(cs==ts){
			for(String  ans: place){
				if(ans!=null){
					System.out.print(ans);
				}
			}
			System.out.println("");
			return;
		}
		for(int i=0;i<place.length;i++){
				if(place[i]==null) {
					char ch=str.charAt(cs);
					place[i]=ch+"";
					printPermutaion(str,place,cs+1,ts);
					place[i]=null;
				}
		}
	}
}