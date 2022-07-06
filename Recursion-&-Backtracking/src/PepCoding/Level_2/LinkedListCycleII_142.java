public class LinkedListCycleII_142{

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
	
	public static Node hasCycle(ListNode head){
		ListNode fast=head;
		ListNode slow=head;
		
		while(fast!=null && fast.next!=null 
			&& slow!=null && slow.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) return true;
		}
		fast=head;
		while(fast!=null && fast.next!=null 
			&& slow!=null && slow.next!=null){
			fast=fast.next;
			slow=slow.next;
			if(fast==slow) return fast;
		}
		
		
		return null;
	}
	
	public static void main(String[] args){
		
		LinkedListCycleII_142 linkedList=new LinkedListCycleII_142();
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		linkedList.addLast(4);
		linkedList.addLast(5);
		display(linkedList.head);
		System.out.println("Hash Cycle >> "+hasCycle(linkedList.head));
		
	}
}