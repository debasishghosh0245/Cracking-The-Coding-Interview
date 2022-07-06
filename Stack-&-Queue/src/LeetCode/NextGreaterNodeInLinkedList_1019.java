import java.util.*;
public class NextGreaterNodeInLinkedList_1019 {
	
	public ListNode head;
	public static class ListNode {
		int data;
		ListNode next;
		ListNode(){
		}
		ListNode(int data){
			this.data=data;
		}
	}
	
	public void addLast(int val) { 
		ListNode node=new ListNode(val);
		if(head==null){
			head=node;
		}else{
			ListNode temp=head;
			while(temp!=null && temp.next!=null){
				temp=temp.next;
			}
			temp.next=node;
		}
	}
	
	public void print(){
		ListNode curr=head;
		while(curr!=null){
			System.out.println(curr.data+" ");
			curr=curr.next;
		}
	}
	
	public int[] nextGreaterNodeRight(){
		ListNode temp=head;
		Stack<Integer> stack=new Stack<>();
		int[] answer=new int[3];
		int i=0;
		while(temp!=null){
			while(!stack.isEmpty() 
				&& stack.peek() < temp.data){
				stack.pop();
			}
			if(stack.isEmpty()){
				answer[i++]=0;
			}else{
				answer[i++]=stack.peek();
			}
			stack.push(temp.data);
			temp=temp.next;
		}
		return answer;
	}

	
	public static void main(String[] args){
		
		NextGreaterNodeInLinkedList_1019 linkedList=new NextGreaterNodeInLinkedList_1019();
		linkedList.addLast(2);
		linkedList.addLast(1);
		linkedList.addLast(5);
		linkedList.print();
		System.out.println(Arrays.toString(linkedList.nextGreaterNodeRight()));
		
	}
}