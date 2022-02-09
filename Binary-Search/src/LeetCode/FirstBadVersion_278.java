package LeetCode;

public class FirstBadVersion_278 {
   public static void main(String[] args) {
       int target=30;
       System.out.println(firstBadVersion(target));
   }

   public static int firstBadVersion(int target) {
       int left=1;
       int right=target;
       while(left<=right) {
           int mid=left+(right-left)/2;
           if(isBadVersion(mid)) {
              right=mid-1;
           }
           else {
             left=mid+1;
           }
       }
       return left;
   } 

   public static boolean isBadVersion(int version) {
       return version>=6;
   }
}


