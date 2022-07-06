public class OddEvenLinkedList{
    
    public static class LinkedList {
		
        private ListNode head;
        private ListNode tail;
        private int size;

        public void addFirst(int val) {
            ListNode temp=new ListNode(val);
            temp.next=this.head;
            tail=head;
            while(null!=tail && tail.next!=null){
                  tail=tail.next;
            }
            this.head=temp;
            size++;
        }
        public void addLast(int data) {
            tail=new ListNode(data);
            if(head==null){
               head=tail;
            }else{
               ListNode current=head;
               while(current.next!=null){
                       current=current.next;
               }
               current.next=tail;
              }
             size++;
        }
        public ListNode removeFirst(){
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
        public int length(ListNode head){
            if(head.next==null) return 1;
            int length=length(head.next);
            return length+1;
        }
    }
   
        private static class ListNode {
           public ListNode next;
           public int data;
            
           ListNode(int data){
             this.data=data;
           }
           ListNode(ListNode next,int data){
             this.data=data;
             this.next=next;
           }  
		}
        public static void main(String[] args) {
            LinkedList list1=new LinkedList();
            list1.addLast(2);
            list1.addLast(1);
            list1.addLast(3);
           /*  list1.addLast(1);
            list1.addLast(5); 
			list1.addLast(4);
			list1.addLast(3); */
            display(list1.head);
			ListNode prnt=oddEven(list1.head);
			System.out.println("Display Odd Even ListNode");
			display(prnt);
        }  	
		//Time Complexity : O(n)
		//Space Complexity : O(1)
		public static ListNode oddEven(ListNode head){
			if(head==null || head.next==null) return head;
			ListNode current=head;
			ListNode oddListNodeHead=new ListNode(-1);
			ListNode oddListNodeTail=oddListNodeHead; 
			ListNode evenListNodeHead=new ListNode(-1);
			ListNode evenListNodeTail=evenListNodeHead;
			while(null!=current){
				ListNode next=current.next;
				if(current.data%2!=0){
					oddListNodeTail.next=current;
					current.next=null;
					oddListNodeTail=oddListNodeTail.next;
				}else{
					evenListNodeTail.next=current;
					current.next=null;
					evenListNodeTail=evenListNodeTail.next;
				}
				current=next;
			}
			oddListNodeTail.next=evenListNodeHead.next;
			return oddListNodeHead.next;
		}
		
		public static ListNode addFirst(ListNode head,int val){
			ListNode ListNode=new ListNode(val);
			if(head==null){
				head=ListNode;
			}else{
				ListNode.next=head;
				head=ListNode;
			}
			return head;
		}
		public static ListNode addLast(ListNode head,ListNode tail){
			if(head==null){
				head=tail;
			}else{
				ListNode temp=head;
				while(null!=temp && 
					null!=temp.next){
					temp=temp.next;
				}
				temp.next=tail;
			}
			return head;
		}
        public static void display(ListNode head){
                ListNode curr=head;
                while(curr!=null){
                   System.out.print(curr.data+" ");
                   curr=curr.next;
            }
            System.out.println(" ");
        }        
}