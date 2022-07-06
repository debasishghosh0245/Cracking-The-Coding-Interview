public class FirstNonRepeatingCharacter {
	
	public static void main(String[] args){
		String str="loveleetcode";
		System.out.println("print 1st non reapting character >> "+firstUniqChar(str));
	}
	
	public static int firstUniqChar(String s) {
        HashMap<Character,Integer> frqMap=new HashMap<>();
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			frqMap.put(ch,frqMap.getOrDefault(ch,0)+1);
		}
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(frqMap.get(ch)==1) return i;
		}
		return -1;
    }
}