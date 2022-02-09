import java.util.*;
public class FibonacciNumber_509 {

    public static void main(String[] args) {
       System.out.println(fib(45));
    }

    public static int fib(int n) {
        HashMap<Integer,Integer> cache=new HashMap<Integer,Integer>();      
        int result;
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        if(n<2) {
           return n;   
        }
        result=fib(n-1)+fib(n-2);
        cache.put(n,result);
        return result;
    }
    
    public static int fib2(int n) {  
        int result;
        if(n>2) {
           result=n;   
        }
        result=fib(n-1)+fib(n-2);
        return result;
    }
}