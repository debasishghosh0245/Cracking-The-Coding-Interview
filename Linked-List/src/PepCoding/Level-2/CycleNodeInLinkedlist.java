import java.io.*;
import java.util.*;
public class CycleNodeInLinkedlist {
    
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
            //8 1 18 1 8 -1 138 31 84 3
			LinkedList list1=new LinkedList();
			ListNode listnode8=new ListNode(8);
			ListNode listnode1=new ListNode(1);
			ListNode listnode18=new ListNode(18);
			ListNode listnode10=new ListNode(-1);
			ListNode listnode138=new ListNode(138);
			ListNode listnode31=new ListNode(31);
			ListNode listnode84=new ListNode(84);
			ListNode listnode3=new ListNode(3);
			
            list1.addLast(listnode8);
            list1.addLast(listnode1);
            list1.addLast(listnode18);
            list1.addLast(listnode1);
			list1.addLast(listnode8);
			list1.addLast(listnode10);
			list1.addLast(listnode138);
			list1.addLast(listnode31);
			list1.addLast(listnode84);
			list1.addLast(listnode3);
			
			System.out.println("Cycle Node >> "+hasCycle(list1.head).data);
        }  

        public static void display(ListNode head) {
			ListNode curr=head;
			while(curr!=null) {
			   System.out.print(curr.data+" ");
			   curr=curr.next;
			}
			System.out.println(" ");
        }  

	    public static ListNode hasCycle(ListNode head){
			ListNode slow=head;
			ListNode fast=head;
			ListNode hasLoop=null;
			while(null!=slow && null!=fast 
				&& null!=fast.next){
				slow=slow.next;
				fast=fast.next.next;
				if(slow==fast){
					hasLoop=slow;
					break;
				}
			}
			return hasLoop;
		}
}

