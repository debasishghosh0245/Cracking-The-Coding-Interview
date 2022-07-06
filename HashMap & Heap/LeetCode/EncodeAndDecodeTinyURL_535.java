import java.util.*;
public class EncodeAndDecodeTinyURL_535{
	
	HashMap<String,String> map=new HashMap<>();
	
	public static void main(String[] args){
		EncodeAndDecodeTinyURL_535 encodeDecode=new EncodeAndDecodeTinyURL_535();
		String encodedStr=encodeDecode.encode("https://leetcode.com/problems/design-tinyurl");
		System.out.println(encodeDecode.decode(encodedStr));
	}
	
	 // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String charSet="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rand=new Random();
		StringBuilder shortURL=new StringBuilder();
		shortURL.append("http://tinyurl.com/");
		for(int i=0;i<6;i++){
			int ch=charSet.charAt(rand.nextInt(26));
			shortURL.append(ch);
		}
		map.put(shortURL.toString(),longUrl);
		System.out.println("Short URL >> "+map);
		return shortURL.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
       return map.get(shortUrl);
    }

}