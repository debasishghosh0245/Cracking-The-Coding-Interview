public class Combinations2{
	
	public static void main(String[] args){
		int[] boxes={0,0,0};
		combination(boxes,1,3,"",0,2);
	}
	
	public static void combination(int[] items,int currentBox,
		int totalBox,String ansfar,int currentItem,int totalItem){
			if(currentBox >	totalBox ){
				if(currentItem==totalItem){
					System.out.println(ansfar);
				}
				return;
			}
			for(int i=0;i<totalItem;i++){
				if(items[i]==0){
					items[i]=1;
					combination(items,currentBox+1,totalBox,ansfar+(i+1),currentItem+1,
					totalItem);
					items[i]=0;
				}
			}
			combination(items,currentBox+1,totalBox,ansfar+"-",currentItem,totalItem);
	}
}