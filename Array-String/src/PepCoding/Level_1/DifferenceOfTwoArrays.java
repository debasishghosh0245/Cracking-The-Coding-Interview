public class DifferenceOfTwoArrays {
    
    public static void main(String[] args) {
        //int[] arr1={3,2,4};
        //int[] arr2={2,8,8};
        int[] arr2={  2,6,7};
        int[] arr1={1,0,0,0};
        difference(arr1,arr2);
    }
    
    public static void difference(int[] arr1,int[] arr2) {
        int[] arr=new int[arr1.length > arr2.length ? arr1.length : arr2.length];
        int i=arr1.length-1;
        int j=arr2.length-1;
        int k=arr.length-1;
        int brw=0;
        
        while(i>=0 || j>=0) {
            int diff=0;
            int temp=j >= 0 ? arr2[j] :0 ;
            if(arr1[i]+brw>=temp){
                diff=arr1[i]+brw-temp;
                brw=0;
            }
            else {
               diff= arr1[i]+10+brw-temp;
               brw=-1;
            }
            arr[k]=diff;
            i--; j--;k--;
        }
        
        for(int val: arr) {
            if(val!=0){
                 System.out.println(val);
            }
        }
    }   
}