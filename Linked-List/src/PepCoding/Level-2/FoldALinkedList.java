public class FoldALinkedList {
    
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
            LinkedList list1=new LinkedList();
            list1.addLast(2);
            list1.addLast(1);
			list1.addLast(0);
            list1.addLast(3);
			list1.addLast(5);
			Node folded=fold(list1.head);
			display(folded);
        }  	
		
		public static void display(Node head){
                Node curr=head;
                while(curr!=null){
                   System.out.print(curr.data+" ");
                   curr=curr.next;
            }
            System.out.println(" ");
        } 
		
		public static Node mid(Node head){
			Node slow=head;
			Node fast=head;
			while(slow!=null && fast!=null 
				&& fast.next!=null){
			    slow=slow.next;
				fast=fast.next.next;
			}
			return slow;
		}
		
		public static Node fold(Node head){
			Node head1=head;
			Node mid=mid(head);
			Node head2=reverse(mid.next);
			mid.next=null;			
			Node temp1=head1;
			Node temp2=head2;
			while(temp1!=null 
				&& temp2!=null){	
				Node next1=temp1.next;
				Node next2=temp2.next;
				temp1.next=temp2;
				temp2.next=next1;
				temp1=next1;
				temp2=next2;
			}
			return head1;
		}

		public static Node reverse(Node head){
			Node prev=null;
			Node curr=head;
			while(curr!=null){
				Node temp=curr.next;
				curr.next=prev;
				prev=curr;
				curr=temp;
			}
			return prev;
		}
}