public class RemoveAllDuplicatesFromSortedLinkedlist{
     
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
	//Spce Complexicy :O(1) because we don't allocate any additional data structure.
	//Time complexity :O(N) since it's one pass along the input list.
    public void removeDuplicate() {
		Node dummyHead=new Node(-1);
		Node dummyTail=dummyHead;
		Node current=head;
        while(current!=null) {
			//if it is begining of duplicate sublist 
			//remove all duplicates 
			if(null!=current.next 
				&& current.data==current.next.data){
				//move to the end of the duplicate sublist
				while(null!=current.next && 
					current.data==current.next.data){
					current=current.next;
				}
				//skip all duplicates 
				dummyTail.next=current.next;
			}else {
				//otherwise move predecessor
				dummyTail=dummyTail.next;
			}
			//move forward
			current=current.next;
        }
		head=dummyHead.next;
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
        //1,2,3,3,4,4,5
		//1,1,1,2,3
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
		list.addLast(2);
		list.addLast(3);
        list.display();
        list.removeDuplicate();
        list.display();
        
    }   
}