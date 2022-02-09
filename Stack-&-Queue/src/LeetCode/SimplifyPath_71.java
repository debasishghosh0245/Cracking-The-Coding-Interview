import java.util.*;
public class SimplifyPath_71 {
    public static void main(String[] args){
		/* String path="/home//foo/";
		String path=" "; */
		String path="/../";

		System.out.println(simplifyPath(path));
	}
	
	public static String simplifyPath(String path) {
		//Initialized a Stack
		Stack<String> stack=new Stack<>();
		StringBuilder sb=new StringBuilder();
		//Split the input string on "/" as a delimeter and process
		//one by one String 
		for(String str: path.split("/")) {
			// if we split a//b  by / then result will be [a, ,b]
			//System.out.println(str);
			if(str.isEmpty()|| str.equals(".")){
				continue;
			}
			else if(str.equals("..")){
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}
			else{
				stack.push(str);
			}
		}
		for(String str: stack) {
			sb.append("/");
			sb.append(str);
		}
		
        return sb.length() > 0 ? sb.toString() : "/";
    }

}