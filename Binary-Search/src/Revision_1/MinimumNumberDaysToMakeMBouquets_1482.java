public class MinimumNumberDaysToMakeMBouquets_1482{
	
	public static void main(String[] args){
		/* int[] bloomDay ={7,7,7,7,12,7,7};
		int m = 2; int k =3; */
		int[] bloomDay={1,10,3,10,2};
		int m=3; int k=1;
		System.out.println(minDays(bloomDay,m,k));
	}
	public static int minDays(int[] bloomDay, int m, int k) {
		//if numbers of flower is less than required 
		if(bloomDay.length <m*k) return -1; 
        int low=0;
		int high=0;
		for(int i=0;i<bloomDay.length;i++){
			low=Math.min(low,bloomDay[i]);
			high=Math.max(high,bloomDay[i]);
		}
		while(low<high){
			int midDay=low+(high-low)/2;
			//System.out.println("mid "+midDay);
			int bouquets=calDays(bloomDay,midDay,k);
			//System.out.println("Bouquest >> "+bouquets);
			if(bouquets >= m ){
				//check for minimum days
				high=midDay;
			}else{
				//check for maximum days
				low=midDay+1;
			}
		}
		return high;
    }
	public static int calDays(int[] bloomDay,int day,int k){
		int bouquets=0;
		int adjacentFlower=0;
	    for(int i=0;i<bloomDay.length;i++){
			if(bloomDay[i] > day){
				adjacentFlower=0;
			}else{
				adjacentFlower++;
				if(adjacentFlower==k) {
					adjacentFlower=0;
					bouquets++;
				}
			}
		}
		return bouquets;
	}
}