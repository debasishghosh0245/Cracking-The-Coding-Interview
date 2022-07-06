public class DigitFrequency {
    
    public static void main(String[] args) {
        int num=994543234;
        int digit=4;
        System.out.println(getDigitFrequency(num,digit));
       
    }
    public static int getDigitFrequency(int num, int digit) {
        int temp=num;
        int frequency=0;
        while(temp>0){
            int rem=temp%10;
            if(rem==digit){
                frequency++;
            }
            temp=temp/10;
        }
        return frequency;
    }
}