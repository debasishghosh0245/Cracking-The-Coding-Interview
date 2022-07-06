import java.util.*;
public class EncodeDecodeTinyURL {

  static HashMap<String,String> map=new HashMap<>();

  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String url=scn.nextLine();
		System.out.println(decode(encode(url)));
  }
    
   	 // Encodes a URL to a shortened URL.
	public static String encode(String longUrl) {
		String charSet="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rand=new Random();
		StringBuilder shortURL=new StringBuilder();
		shortURL.append("https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/encode-and-decode-tinyurl");
		  for(int i=0;i<6;i++){
			int ch=charSet.charAt(rand.nextInt(26));
			shortURL.append(ch);
		  }
		map.put(shortURL.toString(),longUrl);
		return shortURL.toString();
	}

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
       return map.get(shortUrl);
    }
}