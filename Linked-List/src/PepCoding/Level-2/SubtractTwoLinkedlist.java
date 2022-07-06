public class SubtractTwoLinkedlist {
    
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
        public Node removeFirst() {
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
            
		   Node(){}
		   
           Node(int data){
             this.data=data;
           }
		   
           Node(Node next,int data){
             this.data=data;
             this.next=next;
           }  
		}
		
        public static void main(String[] args) {
			//l1 = [7,2,4,3], l2 = [5,6,4]
            LinkedList list1=new LinkedList();
			/* list1.addLast(1);
			list1.addLast(1);
			list1.addLast(1); */
            list1.addLast(1);
            list1.addLast(8);
			list1.addLast(0);
			list1.addLast(5);
			list1.addLast(2);
			list1.addLast(6); 

			LinkedList list2=new LinkedList();
			/* list2.addLast(1);
			list2.addLast(1);
			list2.addLast(1); */
            list2.addLast(8);
            list2.addLast(2);
			list2.addLast(3);
			list2.addLast(7); 

			Node result=substraction(list1.head,list2.head);
			display(result);
        }  	
				
		public static Node reverse(Node head){
			if(head==null || head.next==null) return head;
			Node prev=null;
			Node curr=head;
			while(curr!=null){
				Node next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}
			return prev;
		}
		
		public static void display(Node head) {
            Node curr=head;
            while(curr!=null){
                   System.out.print(curr.data+" ");
                   curr=curr.next;
            }
            System.out.println(" ");
        } 
		
		public static Node substraction(Node head1,Node head2) {
			Node temp1=reverse(head1);
			Node temp2=reverse(head2);
			display(temp1);
			display(temp2);
			Node head=new Node();
			Node temp=head;
			int borrow=0;
			while(temp1!=null || temp2!=null) {
				int x=temp1!=null ? temp1.data : 0;
				int y=temp2!=null ? temp2.data : 0;
				int diff=0;
				if(x<(y+borrow)){
					diff=(x+10)-(y+borrow);
					borrow=1;
				}else{
					diff=x-(y+borrow);
					borrow=0;
				}
			    if(temp==null){
					temp=new Node(diff);
				}else{
					temp.next=new Node(diff);
					temp=temp.next;
				}
				if(temp1!=null) temp1=temp1.next;
				if(temp2!=null) temp2=temp2.next;
			}
			if(borrow>0) {
				temp.next=new Node(borrow);
			}
			Node retNode = reverse(head.next);
			    while(retNode != null){
					if(retNode.data != 0){
						return retNode;
					}
				retNode = retNode.next;
			} 
			return retNode; 
		}
}