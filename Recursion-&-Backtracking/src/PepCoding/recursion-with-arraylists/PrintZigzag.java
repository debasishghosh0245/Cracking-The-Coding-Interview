import java.util.*;
public class PrintZigzag {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);       
        pzz(sc.nextInt());
        System.out.println("");
    }

    // 3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3
    public static void pzz(int n){
        if(n==0) return;
        System.out.print(n);
        pzz(n-1);
        System.out.print(n);
        pzz(n-1);
        System.out.print(n);
    }
}