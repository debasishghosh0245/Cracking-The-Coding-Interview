import java.io.*;
import java.util.*;
public class GetAtDoublyLinkedList {
    
    public static class LinkedList {
		
        private ListNode head;
        private ListNode tail;
        private int size;
		
        public void addFrist(int data) {
            ListNode node=new ListNode(data);
            if(head==null){
				head=tail=node;
            }else{
				node.next=head;
				head.previous=node;
				head=node;
            }
            size++;
        }
		
		public int removeLast(){
			int data=tail.data;
			ListNode prev=tail.previous;
			prev.next=null;
			tail.previous=null;
			this.tail=prev;
			size--;
			return data;
		}
		
        public int length(ListNode head) {
            if(head.next==null) return 1;
            int length=length(head.next);
            return length+1;
        }
		
		public int getAt(int index) {
			if(this.size==0) {
				return -1;
			}
			else if(index < 0 || index > this.size-1) {
				return -1;
			}
			else {
				ListNode curr=head;
				while(null!=curr && index-->0){
					curr=curr.next;
				}
				return curr.data;
			}
		}
    }
	
	public static class ListNode {
			
		public ListNode next;
		public ListNode previous;
		public int data;
		ListNode(int data){
			this.data=data;
		}
		ListNode(int data,ListNode next,ListNode previous){
			this.data=data;
			this.next=next;
		}  
	}
   
	public static void main(String[] args) {

		LinkedList list1=new LinkedList();
		list1.addFrist(1);
		list1.addFrist(2);
		list1.addFrist(3); //2
		list1.addFrist(4);
		list1.addFrist(5);
		
		System.out.println(list1.getAt(4));
	}  

	public static void display(ListNode head) {
		ListNode curr=head;
		while(curr!=null) {
		   System.out.print(curr.data+" ");
		   curr=curr.next;
		}
		System.out.println(" ");
	}  
}

