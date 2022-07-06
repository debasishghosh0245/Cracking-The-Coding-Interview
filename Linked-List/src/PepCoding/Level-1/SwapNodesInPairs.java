public class SwapNodesInPairs {
    
    public static class LinkedList {
       
        private Node head;
        private Node tail;
        private int size;

		public void addFirst(int val) {
			Node temp=new Node(val);
			temp.next=this.head;
			tail=head;
			while(null!=tail && tail.next!=null){
				  tail=tail.next;
			}
			this.head=temp;
			size++;
		}
    
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
	   
		public void display(Node head){
				Node curr=head;
				while(curr!=null){
				   System.out.print(curr.data+" ");
				   curr=curr.next;
			}
			System.out.println(" ");
		}
    
		public Node removeFirst(){
			if(head==null){
				System.out.println("List is empty");
				
			}else if(head.next==null){
				head=tail=null;
				size--;
			}
			else{
				head=head.next;
				size--;
			}
			return head;
		}
		
		public int length(Node head){
			if(head.next==null) return 1;
			int length=length(head.next);
			return length+1;
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
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        //list.display(list.head);
        Node temp=swapPairs(list.head);
        list.display(temp);
	}  

	public static Node swapPairs(Node head) {
        Node tempHead=null;
        Node tempTail=null;
        Node orgHead=null;
        Node orgTail=null;
        Node curr=head;
        int k=2;
        while(curr!=null) {
            tempHead=null;
            tempTail=null;
            k=2;
            while(null!=curr && k>0) {
                Node next=curr.next;
                curr.next=tempHead;
                tempHead=curr;
                if(tempTail==null) {
                    tempTail=tempHead; 
                }
                curr=next;
                k--;
            }
            if(orgHead==null) {
               orgHead=tempHead;
               orgTail=tempTail;
            }else{
               orgTail.next=tempHead;
			   orgTail=tempTail;
            }
        }
         return orgHead;
    }
    
}