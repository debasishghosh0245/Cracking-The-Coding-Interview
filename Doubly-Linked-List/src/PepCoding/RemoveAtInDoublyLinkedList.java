import java.io.*;
import java.util.*;
public class RemoveAtInDoublyLinkedList {
    
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
		
		public void removeAt(int index) {
			if(index < 0 || index > this.size-1 || size==0) {
				System.out.println("IndexIsInValid: -1");
			}
			//remove head node 
			else if(index==0){
				head=head.next;
				size--;
			}
			//remove tail node 
			else if(index==size-1){
				ListNode previous=tail.prev;
				previous.next=null;
				tail.prev=null;
				size--;
				tail=previous;
			}
			else {
				ListNode curr=head;
				while(null!=curr && index-->0){
					curr=curr.next;
				}
				ListNode prevNode=curr.prev;
				ListNode nextNode=curr.next;
				prevNode.next=nextNode;
				nextNode.prev=prevNode;
				curr.next=curr.prev=null;
				size--;
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
		list1.addFrist(1);
		list1.addFrist(2);
		list1.addFrist(3); //2
		list1.addFrist(4);
		list1.addFrist(5);
		display(list1.head);
		list1.removeAt(4);
		list1.removeAt(0);
		list1.removeAt(2);
		System.out.println("After Removed");
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

