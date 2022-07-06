import java.io.*;
import java.util.*;
public class RemoveFirstInDoublyLinkedList {
    
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
		
		public int removeFirst() {
			int data=head.data;
            if(head!=null){
				this.head=this.head.next;
                this.size--;
			}
			return data;
        }
		
        public int length(ListNode head) {
            if(head.next==null) return 1;
            int length=length(head.next);
            return length+1;
        }
    }
	
	public  static class ListNode {
			
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
		//4 4 5 1
		LinkedList list1=new LinkedList();
		list1.addFrist(4);
		list1.addFrist(4);
		list1.addFrist(5);
		list1.addFrist(1); 
		
		System.out.println("Removed "+list1.removeFirst());
		System.out.println("Removed "+list1.removeFirst());
		//list1.removeFirst();
		
		display(list1.head);
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

