public class Combinations1{
	
	public static void main(String[] args){
		combination(1,5,"",0,3);
	}
	
	public static void combination(int currentBox,int totalbox,String ansfar,int currentItem,
	int totalItem){
		if(currentBox >totalbox ){
			if(currentItem==totalItem){
				System.out.println(ansfar);
			}
			return;
		}
		combination(currentBox+1,totalbox,ansfar+"i",currentItem+1,totalItem);
		combination(currentBox+1,totalbox,ansfar+"-",currentItem,totalItem);
	}
}