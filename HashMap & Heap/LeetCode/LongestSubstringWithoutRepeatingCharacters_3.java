public class LongestSubstringWithoutRepeatingCharacters3{
	
	public static void main(String[] args){
		String str="aabcbcdbca";
		System.out.println("Length of the Substring >> "+
		findLongestSubstringNonRepating(str));
	}

	public static int findLongestSubstringNonRepating(String str){
		String result="";
		HashMap<Character,Integer> charFreqMap=new HashMap<>();
		int i=0;
		int j=0;
		while(true){
			boolean flag1=false;
			boolean flag2=false;
			//acuire
			while(i<str.length()){
				flag1=true;
				char ch=str.charAt(i++);
				charFreqMap.put(ch,charFreqMap.getOrDefault(ch,0)+1);
				if(charFreqMap.getOrDefault(ch,0)>1){
					break;
				}
				else{
					String currSubstr=str.substring(j,i);
					if(result.length()==0 || currSubstr.length() > result.length()){
						result=currSubstr;
					}
				}
			}
			//release
			while(j<i){
				flag2=true;
				char ch=str.charAt(j++);
				charFreqMap.put(ch,charFreqMap.getOrDefault(ch,0)-1);
				if(charFreqMap.getOrDefault(ch,0)==1) {
					break;
				}
			}
			if(flag1==false && flag2==false){
				break;
			}
		}
		return result.length();
	}
}