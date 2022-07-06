import java.io.*;
import java.util.*;
public class SegregateNodeLinkedlistOverPivotIndex {
    
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
            //1->0->1->0->0->1->2->1->1->1->2->1->1->null
			//2 2 2 2 2 2 2 2 2 
			LinkedList list1=new LinkedList();
            list1.addLast(2);
            list1.addLast(2);
            list1.addLast(2);
            list1.addLast(2);
			list1.addLast(2);
		/* 	list1.addLast(1);
			list1.addLast(2);
			list1.addLast(1);
			list1.addLast(1);
			list1.addLast(1);
			list1.addLast(2);
			list1.addLast(1);
			list1.addLast(1); */
			display(list1.head);
			ListNode test=segregate012(list1.head);
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
		
		public static ListNode segregate012(ListNode head){
			ListNode nodeZeroHead=new ListNode(-1);
			ListNode nodeZeroTail=nodeZeroHead;
			ListNode nodeOneHead=new ListNode(-1);
			ListNode nodeOneTail=nodeOneHead;
			ListNode nodeTwoHead=new ListNode(-1);
			ListNode nodeTwoTail=nodeTwoHead;
			ListNode current=head;
			while(current!=null){
				if(current.data==0){
					nodeZeroTail.next=current;
					nodeZeroTail=nodeZeroTail.next;
				}
				else if(current.data==1){
					nodeOneTail.next=current;
					nodeOneTail=nodeOneTail.next;
				}else{
					nodeTwoTail.next=current;
					nodeTwoTail=nodeTwoTail.next;
				}
				current=current.next;
			}
			
			nodeOneTail.next=nodeTwoHead.next;
			nodeTwoTail.next=null;
			nodeZeroTail.next=nodeOneHead.next;
			return nodeZeroHead.next;
		} 
}

