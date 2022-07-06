public class PaintHouse_256{

	public static void main(String[] args){
		//int[][] costs={{17,2,17},{16,16,5},{14,3,19}};
		int[][] costs={{7,6,2}};
		/* Integer[][] memo=new Integer[costs.length][costs.length];
		int minCost=Math.min(minCostMemo(costs,costs.length-1,0,memo),
		minCostMemo(costs,costs.length-1,1,memo));
		minCost=Math.min(minCostMemo(costs,costs.length-1,2,memo),minCost);
		System.out.println(minCost);  */
		System.out.println(minCost(costs));
	}
	
	//Approach 1 : Recursion
	//Time Complexity  : O(2^n)
	//Space Complexity : O(n)
	public static int minCostRecursive(int[][] costs,int house,int color){
		if(house==0){
			return costs[0][color];
		}
		int totalCost=0;
		if(color==0){
			int cost1=minCostRecursive(costs,house-1,1);
			int cost2=minCostRecursive(costs,house-1,2);
			totalCost=Math.min(cost1,cost2)+costs[house][color];
		}
		else if(color==1){
			int cost1=minCostRecursive(costs,house-1,0);
			int cost2=minCostRecursive(costs,house-1,2);
			totalCost=Math.min(cost1,cost2)+costs[house][color];
		}
		else if(color==2){
			int cost1=minCostRecursive(costs,house-1,1);
			int cost2=minCostRecursive(costs,house-1,0);
			totalCost=Math.min(cost1,cost2)+costs[house][color];
		}
		return totalCost;
	}
	
	//Approach 1 : Recursion + Memoizaion
	//Time Complexity  : O(n)
	//Space Complexity : O(n+o(house*3))
	public static int minCostMemo(int[][] costs,int house,
		int color,Integer[][] cache){
		if(house==0){
			return costs[0][color];
		}
		if(cache[house][color]!=null){
			return cache[house][color];
		}
		int totalCost=0;
		if(color==0){
			int cost1=minCostMemo(costs,house-1,1,cache);
			int cost2=minCostMemo(costs,house-1,2,cache);
			totalCost=Math.min(cost1,cost2)+costs[house][color];
		}
		else if(color==1){
			int cost1=minCostMemo(costs,house-1,0,cache);
			int cost2=minCostMemo(costs,house-1,2,cache);
			totalCost=Math.min(cost1,cost2)+costs[house][color];
		}
		else if(color==2){
			int cost1=minCostMemo(costs,house-1,1,cache);
			int cost2=minCostMemo(costs,house-1,0,cache);
			totalCost=Math.min(cost1,cost2)+costs[house][color];
		}
		cache[house][color]=totalCost;
		return totalCost;
	}
	

	//Approach 3 : Dynamic Programming 
	//Time Complexity  : O(n)
	//Space Complexity : O(n) //Recursion Space Removed
	public static int minCost(int[][] costs){
		int[][] dp=new int[costs.length][costs[0].length];
		for(int house=0;house<costs.length;house++){
			for(int color=0;color<costs[house].length;color++){
				if(house==0){
					dp[house][color]=costs[house][color];
				}else{
					if(color==0){
						int cost1=dp[house-1][1];
						int cost2=dp[house-1][2];
						dp[house][color]=Math.min(cost1,cost2)+costs[house][color];
					}
					else if(color==1){
						int cost1=dp[house-1][0];
						int cost2=dp[house-1][2];
						dp[house][color]=Math.min(cost1,cost2)+costs[house][color];
					}
					else if(color==2){
						int cost1=dp[house-1][1];
						int cost2=dp[house-1][0];
						dp[house][color]=Math.min(cost1,cost2)+costs[house][color];
					}
				}
			}
		}
		/* for(int row=0;row<costs.length;row++){
			for(int col=0;col<costs[row].length;col++){
				System.out.println("Cost >> "+costs[row][col]);
			}
		} */
		int minCost=Integer.MAX_VALUE;
		for(int col=0;col<dp[0].length;col++){
			minCost=Math.min(dp[dp.length-1][col],minCost);
		}	
		return minCost;
	}
}
