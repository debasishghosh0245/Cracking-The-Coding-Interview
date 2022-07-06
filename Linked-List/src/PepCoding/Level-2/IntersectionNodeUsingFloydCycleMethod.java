import java.io.*;
import java.util.*;
public class IntersectionNodeUsingFloydCycleMethod {
    
    public static class LinkedList {
		
        private ListNode head;
        private ListNode tail;
        private int size;
    
        public void addLast(ListNode node) {
            if(this.head==null){
               head=tail=node;
            }else{
               ListNode tail=head;
               while(null!=tail && tail.next!=null){
                       tail=tail.next;
               }
               tail.next=node;
            }
            size++;
        }
   
        public int length(ListNode head) {
            if(head.next==null) return 1;
            int length=length(head.next);
            return length+1;
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
            //8 1 18 1 8 -1 138 31 84 3
			//listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
			
			LinkedList list1=new LinkedList();
			ListNode listnode4=new ListNode(4);
			ListNode listnode1=new ListNode(1);
			ListNode listnode8=new ListNode(8);
			ListNode listnode5=new ListNode(5);
			ListNode listnode6=new ListNode(6);
			
            list1.addLast(listnode4);
            list1.addLast(listnode1);
            list1.addLast(listnode8);
			list1.addLast(listnode5);
			display(list1.head);
			
			
			LinkedList list2=new LinkedList();
			list2.addLast(listnode5);
			list2.addLast(listnode6);
			list2.addLast(listnode1);
			list2.addLast(listnode8);
			list2.addLast(listnode4);
			display(list2.head);
			
			System.out.println("Intersection Node >> "+getIntersectionNode(list1.head,
			list2.head));
        }  

        public static void display(ListNode head) {
			ListNode curr=head;
			while(curr!=null) {
			   System.out.print(curr.data+" ");
			   curr=curr.next;
			}
			System.out.println(" ");
        }  

	    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			ListNode fast=headA;
			ListNode slow=headB;
			
			while(fast!=null && slow!=null){
                if(fast==slow) {
					return fast;
				}
				fast=fast.next;
				slow=slow.next;
                if(fast==null && slow==null) return null;
                if(fast==null){ fast=headB;	} 
			    if(slow==null){ slow=headA; }
			}
			return null;
        }
}

