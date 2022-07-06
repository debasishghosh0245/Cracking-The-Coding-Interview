package LeetCode;

public class GuessNumberHigherOrLower_374 {
    public static void main(String[] args) {
        int target = 10;
        System.out.println(guessNumber(target));
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) < 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int guess(int target) {
        int pick=6;
        if (target < pick)
            return 1;
        else if (target > pick)
            return -1;
        else
            return 0;
    }
}
