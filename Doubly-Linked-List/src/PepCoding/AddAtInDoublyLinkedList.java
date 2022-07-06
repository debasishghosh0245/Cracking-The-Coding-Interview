import java.io.*;
import java.util.*;
public class AddAtInDoublyLinkedList {
    
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
				head.prev=node;
				head=node;
            }
            size++;
        }
		
		public int removeLast(){
			int data=tail.data;
			ListNode prev=tail.prev;
			prev.next=null;
			tail.prev=null;
			this.tail=prev;
			size--;
			return data;
		}
		
        public int length(ListNode head) {
            if(head.next==null) return 1;
            int length=length(head.next);
            return length+1;
        }
		
		public void addAt(int index,int data) {
			ListNode node=new ListNode(data);
			if(index < 0 || index > this.size) {
				System.out.println("Invalid Index");
			}
			else{
				if(index==0){
					if(head==null){
						head=tail=node;
					}else{
						head.prev=node;
						node.next=head;
						head=node;
					}
					this.size++;
				}
				else if(index==this.size){
					tail.next=node;
					node.prev=tail;
					tail=node;
					this.size++;
				}
				else {
					ListNode curr=head;
					while(null!=curr && index-->0){
						curr=curr.next;
					}
					ListNode prev=curr.prev;
					prev.next=node;
					node.prev=prev;
					node.next=curr;
					curr.prev=node;
					this.size++;
				}
			}
		}
    }
	
	public static class ListNode {
			
		public ListNode next;
		public ListNode prev;
		public int data;
		ListNode(int data){
			this.data=data;
		}
		ListNode(int data,ListNode next,ListNode prev){
			this.data=data;
			this.next=next;
		}  
	}
   
	public static void main(String[] args) {

		LinkedList list1=new LinkedList();
		list1.addAt(0,1);
		list1.addAt(1,2);
		list1.addAt(2,20);
		list1.addAt(3,30);
		
		//list1.addAt(2,3);
		//display(list1.head);
		//list1.addAt(4,10);
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

