package unacademy;

public class SkipString {
   public static void main(String[] args) {
      String str = "ABABABACCAAA";
      System.out.println(skipString(str, ""));
   }

   public static String skipString(String unprocessedString, String processedString) {
      if (unprocessedString.isEmpty())
         return processedString;
      char ch = unprocessedString.charAt(0);
      if (ch == 'A') {
         return skipString(unprocessedString.substring(1), processedString);
      } else {
         return skipString(unprocessedString.substring(1), processedString + ch);
      }
   }
}
