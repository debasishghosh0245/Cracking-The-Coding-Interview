import java.util.*;


public class SubSetString {

    public static void main(String[] args) {
        //String str="abcabcabcabcabcabcabcabcabcab";
		String str="abc";
        getSubset2(str,new String());
        //System.out.println(output);
    }

    public static List<String> getSubset(String str) {
        if (str.length()== 0) {
            List<String> newList=Arrays.asList("");
            return newList;
        }
        char ch = str.charAt(0);
        String ros=str.substring(1);
        List<String> rresult = getSubset(ros);
        List<String> finalOutput = new ArrayList<>();
		finalOutput.addAll(rresult);
        for (String rr : rresult) {
            finalOutput.add(ch+rr);
        }
        return finalOutput;
    }
	
	public static void getSubset2(String str,String output) {
        if (str.length()== 0) {
            System.out.println(output);
            return;
        }
        char ch = str.charAt(0);
        String ros=str.substring(1);
        getSubset2(ros,output+"");
		getSubset2(ros,output+ch);
    }
}