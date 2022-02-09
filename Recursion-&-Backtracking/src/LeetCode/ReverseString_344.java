public class ReverseString_344 {
    public static void main(String[] args) {
        char[] arr = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(arr);
    }

    public static void reverseString(char[] s) {
        if (s.length == 0)
            return;
        reverseString(s);
        System.out.println(s);
    }
}
