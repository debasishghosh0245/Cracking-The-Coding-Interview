package LeetCode;

import java.util.Arrays;

class KokoEatingBananas_875 {
              
        public static void main(String[] args) {  
            int[] piles = {30,11,23,4,20}; int h = 5;
            Arrays.sort(piles);
            System.out.println("Minimum eating Speed  >> "+minEatingSpeed(piles,h));
        }
        
        public static int minEatingSpeed(int[] piles, int minHrs) {
             int lowEatingSpeed=1;
             int highEatingSpeed=piles[piles.length-1];
             while(lowEatingSpeed <= highEatingSpeed) {
                 int midEatingSpeed=lowEatingSpeed+(highEatingSpeed-lowEatingSpeed)/2;
                 if(isPossible(piles,midEatingSpeed,minHrs)) {
                   highEatingSpeed=midEatingSpeed-1;
                 }else{
                   lowEatingSpeed=midEatingSpeed+1;
                 }
             }
            return lowEatingSpeed;
        }
        
        public static boolean isPossible(int[] piles,int midEatingSpeed,int minHrs) {
            int sum=0;
            for(int i=0;i<piles.length;i++ ){
               if(piles[i]%midEatingSpeed==0){
                   sum=sum+piles[i]/midEatingSpeed;
               }else{
                   sum=sum+piles[i]/midEatingSpeed+1;
               }
            }
            return sum<=minHrs;
        }

}