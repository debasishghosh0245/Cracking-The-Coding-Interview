package Basic;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(fibonacci(i) + "  ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 0) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
