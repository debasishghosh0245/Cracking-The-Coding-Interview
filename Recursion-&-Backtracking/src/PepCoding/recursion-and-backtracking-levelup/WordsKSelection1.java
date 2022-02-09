public class WordsKSelection1{
	
	public static void main(String[] args){
		combination("abcde","",3);
	}
	
	public static void combination(String str,String ansf,int k){
		if(str.length()==0) {
			if(ansf.length()==k){
				System.out.println(ansf);
			}
			return;
		}
		char ch=str.charAt(0);
	    str=str.substring(1);
		combination(str,ansf+ch,k);
		combination(str,ansf+"",k);
	}
}
