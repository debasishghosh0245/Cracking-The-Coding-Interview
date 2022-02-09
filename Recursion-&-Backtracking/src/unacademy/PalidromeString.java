package unacademy;

public class PalidromeString {
    public static void main(String[] args) {
        String str = "DEBASISH";
        String k = reverseStr(str, new ReversedString());
        System.out.println(k);
    }

    private static String reverseStr(String str, ReversedString rev) {
        if ((str == null) || (str.length() <= 1))
            return "";
        reverseStr(str.substring(0, str.length() - 1), rev);
        rev.revString = rev.revString + str.charAt(str.length() - 1);
        return rev.revString;
    }

    public static char[] reverseString(char[] arr, int index) {
        int length = arr.length;
        if (index > length / 2)
            return arr;
        swapChar(arr, index);
        reverseString(arr, index + 1);
        return arr;
    }

    public static void swapChar(char[] arr, int index) {
        int length = arr.length;
        char temp = arr[index];
        arr[index] = arr[length - index - 1];
        arr[length - index - 1] = temp;
    }

}

class ReversedString {
    String revString = "";
}
