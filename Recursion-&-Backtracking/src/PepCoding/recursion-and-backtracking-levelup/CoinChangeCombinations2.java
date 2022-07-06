public class CoinChangeCombinations2{

    public static void main(String[] args){
       int[] coins={2,3,5,6,7};
       int target=12;
       coinChange(coins,0,target,0,"");
    }
    
    public static void coinChange(int[] coins,int idx,int target,int targetSf,String ansf){
        if(idx==coins.length){
            if(targetSf==target){
                System.out.println(ansf); 
            }
            return;
        }
        if(targetSf < target) {
            coinChange(coins,idx+1,target,targetSf,ansf);
            coinChange(coins,idx+1,target,targetSf+coins[idx],ansf+coins[idx]+"-");
        }   
    }
}