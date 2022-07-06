package LeetCode;

public class CapacityToShipPackagesWithinDDays_1011{


    public static void main(String[] args) {
        
    //   int[] weights = {1,2,3,4,5,6,7,8,9,10}; int days = 5;
    //   int[] weights = {3,2,2,4,1,4}; int days = 3;
        int[] weights = {1,2,3,1,1}; int days = 4;
       System.out.println(shipWithinDays(weights,days));
       
    }
    
    
    public static int shipWithinDays(int[] weights, int days) {
        int low=0,high=0;
        for(int weight:weights ) {
            low=Math.max(low,weight);
            high+=weight;
        }
        System.out.println("low >> "+low+" high>>" +high);
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(isPossible(weights,days,mid)) {
              high=mid-1;  
            }else{
              low=mid+1;
            }
        }
        return low;
    }
    
    public static boolean isPossible(int[] weights,int days,int target) {
        int sum=0;
        for(int i=0;i<weights.length;i++) {
            sum+=weights[i];
            if(sum>target) {
                sum=0;
                i--;
                days--;
                }
        }
        return days>=1;
    }

}