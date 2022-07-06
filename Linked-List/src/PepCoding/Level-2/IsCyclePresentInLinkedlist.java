import java.io.*;
import java.util.*;
public class IsCyclePresentInLinkedlist {
    
    public static class LinkedList {
		
        private ListNode head;
        private ListNode tail;
        private int size;
    
        public void addLast(ListNode node) {
            tail=node;
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
            
			LinkedList list1=new LinkedList();
			ListNode listnode3=new ListNode(3);
			ListNode listnode2=new ListNode(2);
			ListNode listnode0=new ListNode(0);
			ListNode listnode4=new ListNode(-4);
            list1.addLast(listnode3);
            list1.addLast(listnode2);
            list1.addLast(listnode0);
            list1.addLast(listnode4);
			//list1.addLast(listnode2);
			System.out.println(hasCycle(list1.head));
        }  

        public static void display(ListNode head) {
			ListNode curr=head;
			while(curr!=null) {
			   System.out.print(curr.data+" ");
			   curr=curr.next;
			}
			System.out.println(" ");
        }  

	    public static boolean hasCycle(ListNode head){
			ListNode slow=head;
			ListNode fast=head;
			boolean hasLoop=false;
			while(null!=slow && null!=fast 
				&& null!=fast.next){
				slow=slow.next;
				fast=fast.next.next;
				if(slow==fast){
					hasLoop=true;
					break;
				}
			}
			return hasLoop;
		}
}

