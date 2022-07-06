import java.util.*;
public class OnlineStockSpan_901{
	
	Stack<Pair> stack=null;
	int count=0;
	public static void main(String[] args){
		//int[] price={100,80,60,70,60,75,85};
		OnlineStockSpan_901 stockSp=new OnlineStockSpan_901();
		System.out.println(stockSp.next(100));
		System.out.println(stockSp.next(80));
		System.out.println(stockSp.next(60));
		System.out.println(stockSp.next(70));
		System.out.println(stockSp.next(60));
		System.out.println(stockSp.next(75));
		System.out.println(stockSp.next(85));
	}
	
	public static class Pair{
		public int price;
		public int index;
		
		Pair(){
		}
		Pair(int price, int index){
			 this.price=price;
			 this.index=index;
		}
	}
	
	public OnlineStockSpan_901() {
        stack=new Stack<>();
    }
    
    public int next(int price) {
		int span=0;
		while(!stack.isEmpty() 
				&&  stack.peek().price < price) {
			stack.pop();
		}
		if(stack.isEmpty()){
			span=count+1;
		}else{
			span=count-stack.peek().index;
		}
		Pair pair=new Pair(price,count);
		stack.push(pair);
		count++;
		return span;
    }
}