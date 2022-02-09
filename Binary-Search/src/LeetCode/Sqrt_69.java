package LeetCode;
// Given a non-negative integer x, compute and return the square root of x. Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
// Input: x = 8 Output: 2 Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
public class Sqrt_69 {
    public static void main(String[] args) {
        int target = 25;
        int left=1, right=Integer.MAX_VALUE;
        System.out.println(getSquareRoot(target,left,right));
    }

    public static int getSquareRoot(int target,int left,int right) {
        if(left>right) return right;
        int mid=(left+(right-left)/2);
        if(target/mid==mid) return  mid;
        return target/mid > mid ?  getSquareRoot(target,mid+1,right) : getSquareRoot(target,left,mid-1);
    }
}
