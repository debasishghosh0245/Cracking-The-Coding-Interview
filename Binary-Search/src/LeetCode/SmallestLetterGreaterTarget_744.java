package LeetCode;

public class SmallestLetterGreaterTarget_744 {
    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'a';
        System.out.println("Print Greatest Letter " + nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (letters[mid] == target) {
                return letters[mid+1];
            } else if (target > letters[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left%letters.length];
    }
}
