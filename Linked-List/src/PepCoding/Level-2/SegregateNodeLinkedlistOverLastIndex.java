import java.io.*;
import java.util.*;
public class SegregateNodeLinkedlistOverLastIndex {
    
    public static class LinkedList {
		
        private ListNode head;
        private ListNode tail;
        private int size;
    
        public void addLast(int data) {
            ListNode tail=new ListNode(data);
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
            //1->5->2->9->5->14->11->1->10->10->1->3->null
			LinkedList list1=new LinkedList();
            list1.addLast(1);
            list1.addLast(5);
            list1.addLast(2);
            list1.addLast(9);
			list1.addLast(5);
			list1.addLast(14);
			list1.addLast(11);
			list1.addLast(1);
			list1.addLast(10);
			list1.addLast(10);
			list1.addLast(1);
			list1.addLast(3);
			//display(list1.head);
			ListNode test=segregateOnLastIndex(list1.head);
			display(test);
        }  

        public static void display(ListNode head) {
			ListNode curr=head;
			while(curr!=null) {
			   System.out.print(curr.data+" ");
			   curr=curr.next;
			}
			System.out.println(" ");
        }  
		
		public static ListNode segregateOnLastIndex(ListNode head) {
			ListNode tail=head;
			while(tail.next!=null){
				tail=tail.next;
			}
			System.out.println("Tail Node"+tail.data);
			ListNode tempHead=new ListNode(-1);
			ListNode tempTail=tempHead;
			ListNode current=head;
			while(current!=null){
				if(current.data > tail.data){
					tempTail.next=current;
					tempTail=tempTail.next;
				}
				current=current.next;
			}
			tail.next=tempHead.next;
			tempTail.next=null;
			return tail;
		} 
}

