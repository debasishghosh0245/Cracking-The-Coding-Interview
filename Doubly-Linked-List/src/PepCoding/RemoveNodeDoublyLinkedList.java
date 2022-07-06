import java.io.*;
import java.util.*;
public class RemoveNodeDoublyLinkedList {
    
    public static class LinkedList {
		
        private ListNode head;
        private ListNode tail;
        private int size;
		
        public void addFrist(ListNode node) {
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
		
		public int removeNode(ListNode refNode) {
			if(refNode.prev==null){
				head=head.next;
			}else{
				ListNode previous=refNode.prev;
				ListNode nextNode=refNode.next;
				previous.next=nextNode;
				nextNode.prev=previous;
			}
			size--;
			return refNode.data;
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
			this.prev=prev;
		}  
	}
   
	public static void main(String[] args) {

		LinkedList list1=new LinkedList();
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		list1.addFrist(node1);
		list1.addFrist(node2);
		list1.addFrist(node3); //2
		list1.addFrist(node4);
		list1.addFrist(node5);
		display(list1.head);
		list1.removeNode(node5);
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

