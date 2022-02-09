public class ReverseString {

    public static void main(String[] args) {
        char[] s={'h','e','l','l','o'};
        reverseString(s);
    }    
    
    public static void reverseString(char[] s) {
       helper(s,0); 
       System.out.println(s);        
    }
    
    public static void helper(char[] s,int idx) {
        if(s.length/2==idx) return; 
        char temp=s[s.length-1-idx];
        s[s.length-1-idx]=s[idx];
        s[idx]=temp;
        helper(s,idx+1);
    }
}

