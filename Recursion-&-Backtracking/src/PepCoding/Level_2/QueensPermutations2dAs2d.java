public class QueensPermutations2dAs2d {

	public static void main(String[] args){
		int[][] boxes=new int[2][2];
		queensPermution(boxes,1,2);
	}
	
	public static void queensPermution(int[][] boxes,int itemsf,int totalItems){
		if(itemsf>totalItems){
			for(int row=0;row<boxes.length;row++){
				for(int col=0;col<boxes[0].length;col++){
					if(boxes[row][col]!=0){
						System.out.print("q"+boxes[row][col]+"\t");
					}else{
						System.out.print("-\t");
					}
				}
				System.out.println("");
			}
			
			return;
		}
		for(int row=0;row<boxes.length;row++){
			for(int col=0;col<boxes[0].length;col++){
				if(boxes[row][col]==0){
					boxes[row][col]=itemsf;
					queensPermution(boxes,itemsf+1,totalItems);
					boxes[row][col]=0;
				}
			}
		}
	}

}