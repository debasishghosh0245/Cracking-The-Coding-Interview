

public class PowerOfTwo_231 {

     public static void main(String[] args) {
          System.out.println(isPowerOfTwo(90));
     }

     public static boolean isPowerOfTwo(int n) {
          while (n % 2 == 0)  n /= 2;
          return n==1;
     }
}