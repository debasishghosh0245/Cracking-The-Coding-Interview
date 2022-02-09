
public class Pow_xn_50 {
  public static void main(String[] args) {
    System.out.println(pow(2.10000, 3));
  }

  public static double pow(double x, int n) {
    if (n == 0)
      return 1; // base case
    if (n < 0) {
      n = -n;
      return 1 / pow(x, n);
    }
    return n % 2 == 0 ? pow(x, n / 2) * pow(x, n / 2) : x * pow(x, n / 2) * pow(x, n / 2);
  }
}
