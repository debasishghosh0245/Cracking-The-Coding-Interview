public class MiddleOfTheLinkedList_876{

	public ListNode head;
	public ListNode tail;
	public int size;

	public static class ListNode{
		int val;
		ListNode next;
		
		ListNode(int val){
			this.val=val;
		}
	}
	
	
	public ListNode addLast(int data){
		ListNode node=new ListNode(data);
		if(head==null) {
			head=tail=node;
		}else{
			tail.next=node;
			tail=node;
		}
		return head;
	}
	
	public static void display(ListNode head){
		if(head==null) return;
		System.out.print(head.val+" ");
		display(head.next);
	}
	
	public static int findMiddle(ListNode head){
		ListNode fast=head;
		ListNode slow=head;
		
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		
		return slow.val;
	}
	
	public static void main(String[] args){
		
		MiddleOfTheLinkedList_876 linkedList=new MiddleOfTheLinkedList_876();
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		linkedList.addLast(4);
		linkedList.addLast(5);
		display(linkedList.head);
		
		System.out.println("Middle Node >> "+findMiddle(linkedList.head));
		
	}

}