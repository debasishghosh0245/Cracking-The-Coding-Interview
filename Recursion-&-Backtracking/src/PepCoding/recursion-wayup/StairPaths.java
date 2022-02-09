import java.util.*;

public class StairPaths {

    public static void main(String[] args) throws Exception {
		 List<String> output= getStairPathsSpaceOptimized(4,"",new ArrayList<String>());
        //ArrayList<String> output = getStairPaths(4);
         System.out.println(output);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> newList = new ArrayList<String>();
            newList.add("");
            return newList;
        }
        ArrayList<String> rr1 = null;
        ArrayList<String> rr2 = null;
        ArrayList<String> rr3 = null;
        if (n - 1 >= 0) {
            rr1 = getStairPaths(n - 1);
        }
        if (n - 2 >= 0) {
            rr2 = getStairPaths(n - 2);
        }
        if (n - 3 >= 0) {
            rr3 = getStairPaths(n - 3);
        }
        ArrayList<String> result = new ArrayList<String>();
        if (rr1 != null) {
            for (String ss1 : rr1) {
                result.add("1" + ss1);
            }
        }
        if (rr2 != null) {
            for (String ss2 : rr2) {
                result.add("2" + ss2);
            }
        }
        if (rr3 != null) {
            for (String ss3 : rr3) {
                result.add("3" + ss3);
            }

        }
        return result;
    }
	
	
	 public static List<String> getStairPathsSpaceOptimized(int n,String ans,List<String> list) {
        if (n == 0) {
            list.add(ans);
        }
        if (n - 1 >= 0) {
            getStairPathsSpaceOptimized(n - 1,ans+"1",list);
        }
        if (n - 2 >= 0) {
           getStairPathsSpaceOptimized(n - 2,ans+"2",list);
        }
        if (n - 3 >= 0) {
           getStairPathsSpaceOptimized(n - 3,ans+"3",list);
        }
		return list;
    }
}
	
	
	
	