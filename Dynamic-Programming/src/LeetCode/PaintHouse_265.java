public class PaintHouse_265{

	public static void main(String[] args){
		//int[][] costs={{17,2,17},{16,16,5},{14,3,19}};
		int[][] costs={{17,9,6,2,6,18,8,12,3,5,9,11,20,8,13,16}};
		//int[][] costs={{7,6,2}};
		Integer[][] memo=new Integer[costs.length][costs[0].length];
		int minCost=Integer.MAX_VALUE;
		int k=costs[0].length;
		for(int color=0;color <costs[0].length ; color++) {
			minCost=Math.min(minCost,minCostMemo(costs,costs.length-1,color,k,memo));
		} 
		System.out.println(minCost);
		//System.out.println(minCostDP(costs));
	}
	
	//Approach 1 : Recursion
	//Time Complexity : O((k-1)^n)
	//Space Complexity : 
	public static int minCostRecursive(int[][] costs,int house,int color,int k){
		if(house==0){
			return costs[0][color];
		}
		int minCost=Integer.MAX_VALUE;
		for(int nextColor=0; nextColor<k; nextColor++){
			if(nextColor!=color){
				minCost=Math.min(minCost,minCostRecursive(costs,house-1,nextColor,k));
				System.out.println("Min Cost "+minCost);
			}
		}
		return minCost+costs[house][color];
	}
	
	//Approach 1 : Recursion + Memoizaion
	//Time Complexity  : O(n*k2)
	//Space Complexity : O(n*k)
	public static int minCostMemo(int[][] costs,int house,int color,int k,Integer[][] memo){
		if(house==0){
			return costs[0][color];
		}
		if(memo[house][color]!=null){
			return memo[house][color];
		}
		int minCost=Integer.MAX_VALUE;
		for(int nextColor=0; nextColor<k; nextColor++){
			if(nextColor!=color){
				minCost=Math.min(minCost,minCostMemo(costs,house-1,nextColor,k,memo));
			}
		}
		int totalCost=minCost+costs[house][color];
		memo[house][color]=totalCost;
		return totalCost;
	}
	

	//Approach 3 : Dynamic Programming 
	//Time Complexity  : O(n*k2) where n is the number of house and k is color 
	//Space Compleixty : O(n*k) for the array 
	public static int minCostDP(int[][] costs){
		int[][] dp=new int[costs.length][costs[0].length];
		for(int house=0;house<costs.length;house++){
			for(int color=0;color<costs[0].length;color++){
				if(house==0){
					dp[house][color]=costs[house][color];
				}else{
					int minCost=Integer.MAX_VALUE;
					for(int nextColor=0;nextColor<costs[0].length;nextColor++){
						if(nextColor!=color){
							minCost=Math.min(minCost,dp[house-1][nextColor]);
						}
					}
					dp[house][color]=minCost+costs[house][color];
				}
			}
		}
		for(int row=0;row<costs.length;row++){
			for(int col=0;col<costs[row].length;col++){
				System.out.print("Cost >> "+costs[row][col]);
			}
			System.out.println();
		} 
		int result=Integer.MAX_VALUE;
		for(int col=0;col<dp[0].length;col++){
			result=Math.min(dp[dp.length-1][col],result);
		}	
		return result;
	}
}
