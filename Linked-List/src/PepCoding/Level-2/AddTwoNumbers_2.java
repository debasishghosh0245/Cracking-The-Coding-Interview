public class  AddTwoNumbers_2 {
    
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
			//l1 = [2,4,3], l2 = [5,6,4]
			//l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
            LinkedList list1=new LinkedList();
            list1.addLast(2);
            list1.addLast(4);
			list1.addLast(3);
			/* list1.addLast(9);
            list1.addLast(9);
			list1.addLast(9);
			list1.addLast(9); */
			
			LinkedList list2=new LinkedList();
            list2.addLast(5);
            list2.addLast(6);
			list2.addLast(4);
			/* list2.addLast(9); */

			Node result=add(list1.head,list2.head);
			display(result);
        }  	
		
		public static void display(Node head){
            Node curr=head;
            while(curr!=null){
                   System.out.print(curr.data+" ");
                   curr=curr.next;
            }
            System.out.println(" ");
        } 
		
		public static Node add(Node head1,Node head2){
			Node temp1=head1;
			Node temp2=head2;
			Node node=new Node();
			Node temp=node;
			int carry=0;
			while(temp1!=null || temp2!=null){
				int x=temp1!=null ? temp1.data : 0;
				int y=temp2!=null ? temp2.data : 0;
				int sum=x+y+carry;
                carry=sum/10;	
			    if(temp==null){
					temp=new Node(sum%10);
				}else{
					temp.next=new Node(sum%10);
					temp=temp.next;
				}
				if(temp1!=null) temp1=temp1.next;
				if(temp2!=null) temp2=temp2.next;
			}
			
			if(carry>0){
				temp.next=new Node(carry);
			}
			return node.next;
		}
}