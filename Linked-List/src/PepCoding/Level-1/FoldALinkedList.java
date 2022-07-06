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
            list1.addLast(3);
			list1.addLast(5);
			reverse(list1.head,2);
			System.out.println("Display Reverse Version");
			display(list1.head);
        }  	
		
		public static void display(Node head){
                Node curr=head;
                while(curr!=null){
                   System.out.print(curr.data+" ");
                   curr=curr.next;
            }
            System.out.println(" ");
        } 

		public static Node left=null;
		public static void fold(Node head,int floor){
			left=head;
			fold(left,floor);
		}
		
		public static void floodHelper(Node right,int floor){
			if(right==null) return;
			floodHelper(right.next,floor+1);
			if(floor > size/2){
				Node temp=left.next;
				left.next=right;
				right.next=temp;
				left=temp;
			}else if(floor==size/2){
				tail=right;
				tail.next=null;
			}
		}
}