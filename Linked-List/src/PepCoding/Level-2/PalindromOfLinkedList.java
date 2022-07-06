import java.util.*;
public class PalindromOfLinkedList{
     
    public static class LinkedList {
        private ListNode head;
        private ListNode tail;
        private int size;
        
    public void addLast(int data) {
        tail=new ListNode(data);
        if(head==null){
           head=tail;
        }else{
           ListNode current=head;
           while(current.next!=null){
                   current=current.next;
           }
           current.next=tail;
          }
         size++;
    }
    
    public int getLast(){
        ListNode temp=head;
        while(temp.next!=null) {
            temp=temp.next;
        }
        if(temp!=null){
            return temp.data;
        }else{
            System.out.println("List is Empty");
            return -1;
        } 
    }
	
    public int removeLast() {
        ListNode temp=head;
        while(temp.next.next!=null) {
            temp=temp.next;
        }
        if(null!=temp){
            temp.next=null;
            tail=temp;
        }
        size--;
        return temp.data;
    }
   
    public void display(){
        ListNode curr=head;
        while(curr!=null){
           System.out.print(curr.data+" ");
           curr=curr.next;
        }
        System.out.println(" ");  
    }
    
    public int mid(){
        ListNode fast=head;
        ListNode slow=head;
        while(null!=slow && null!=fast 
        && null!=fast.next && null!=fast.next.next){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
}

    private static class ListNode {
        public ListNode next;
        public int data;
        ListNode(int data){
         this.data=data;
        }
        ListNode(ListNode next,int data){
         this.data=data;
         this.next=next;
        }  
    }
    
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(20);
		list.addLast(10);
        list.display(); 
		System.out.println(isPalindrom(list.head));
    }   
    
	public static boolean isPalindrom(ListNode head){
		ListNode slow=head;
		ListNode fast=head;
		Stack<ListNode> stack=new Stack<>();
		while(slow!=null && fast!=null 
			&&  fast.next!=null){
			stack.push(slow);
			slow=slow.next;
			fast=fast.next.next;
		}
		if(fast!=null){
			slow=slow.next;
		}
		while(!stack.isEmpty() && slow!=null){
			if(stack.pop().data!=slow.data) return false;
			slow=slow.next;
		}
		return true;
	}
}