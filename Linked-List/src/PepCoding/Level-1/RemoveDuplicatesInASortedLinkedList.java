public class RemoveDuplicatesInASortedLinkedList{
     
    public static class LinkedList {
        private Node head;
        private Node tail;
        private int size;
        
    public void addLast(int data) {
        tail=new Node(data);
        if(head==null){
           head=tail;
        }else{
           Node current=head;
           while(current.next!=null){
                   current=current.next;
           }
           current.next=tail;
        }
        size++;
    }
    
    public int getLast(){
        Node temp=head;
        while(temp.next!=null) {
            temp=temp.next;
        }
        if(temp!=null){
            return temp.data;
        }else{
            System.out.println("List is Empty");
            return -1;
        } 
    }
    
    public int removeLast() {
        Node temp=head;
        while(temp.next.next!=null) {
            temp=temp.next;
        }
        if(null!=temp){
            temp.next=null;
            tail=temp;
        }
        size--;
        return temp.data;
    }
   
    public void display(){
        Node curr=head;
        while(curr!=null){
           System.out.print(curr.data+" ");
           curr=curr.next;
        }
        System.out.println(" ");  
    }

	//Time Complexity: O(n) 
	//Space Complexity : O(1)
    public void removeDuplicate(){
        Node curr=head;
		while(null!=curr && curr.next!=null){
			if(curr.data==curr.next.data){
				curr.next=curr.next.next;
			}else{
				curr=curr.next;
			}
		}
    }
	
	}
    private static class Node {
        public Node next;
        public int data;
        Node(int data){
         this.data=data;
        }
        Node(Node next,int data){
         this.data=data;
         this.next=next;
        }  
    }
    
    public static void main(String[] args) {
       
        LinkedList list=new LinkedList();
        //2 2 2 3 3 5 5 5 5 5
        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(5);
        list.addLast(5);
        list.addLast(5);
        list.addLast(5);
        list.addLast(5); 
        list.display();
        
        list.removeDuplicate();
        
        list.display();
        
    }   
}