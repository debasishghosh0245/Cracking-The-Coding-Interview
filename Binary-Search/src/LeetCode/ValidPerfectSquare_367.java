package LeetCode;

public class ValidPerfectSquare_367 {
    public static void main(String[] args) {
        int num = 9;
        System.out.println(isPerfectSquare(num));
    }
    public static boolean isPerfectSquare(int num) {
        int left=1;
        int right=num;
        while(left<=right) {
            long mid=left+(right-left)/2;
            if(mid*mid==num) {
                   return true;
            } else if(num<mid*mid) {
                   right=(int)mid-1;
            }else{
                   left=(int)mid+1;
            }
        }
        return false;
    }
}
