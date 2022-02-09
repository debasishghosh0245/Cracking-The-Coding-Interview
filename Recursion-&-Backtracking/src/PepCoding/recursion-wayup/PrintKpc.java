public class PrintKpc {

    public static String[] keys={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    
    public static void main(String[] args) {
        String str="78";
        printKPC(str,"");
    }
    
    public static void printKPC(String str, String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        String currentKay=keys[ch-'0'];
        for(int i=0;i<currentKay.length();i++) {
             char charOfKey=currentKay.charAt(i);
             printKPC(ros,asf+charOfKey);
        }
    }
}