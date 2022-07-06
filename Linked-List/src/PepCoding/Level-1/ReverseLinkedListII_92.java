public class ReverseLinkedListII_92 {
     
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
			System.out.println("");
        }

        public Node getAt(int idx) {
            Node temp=head;
            while(temp.next!=null && idx!=0){
                temp=temp.next;
                idx--;
            }
            return temp; 
        }
    
        public Node reverse(int low,int high){
            Node tempHead=null;
            Node tempTail=null;
            Node curr=head; 
			Node con=null;
			while(low > 1){
				con=curr;
				curr=curr.next;
				low--;
				high--;
			}
		    while(high > 0){
				Node temp=curr.next;
				curr.next=tempHead;
				tempHead=curr;
				if(tempTail==null) {
					tempTail=tempHead;
				}
				high--;
				curr=temp;  
			}
			tempTail.next=curr;
			if(con!=null){
				con.next=tempHead;
			} else{
				head=tempHead;
			} 
            return head;
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
        LinkedList linkedList=new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
       /*  linkedList.addLast(3);
        linkedList.addLast(4); 
        linkedList.addLast(5);  */
        linkedList.display(linkedList.head);
        Node node=linkedList.reverse(1,2);
        linkedList.display(node);
    }   
    
}