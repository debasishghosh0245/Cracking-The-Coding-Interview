public class OddEvenLinkedList{
    
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
            LinkedList list1=new LinkedList();
            list1.addLast(2);
            list1.addLast(1);
            list1.addLast(3);
           /*  list1.addLast(1);
            list1.addLast(5); 
			list1.addLast(4);
			list1.addLast(3); */
            display(list1.head);
			Node prnt=oddEven(list1.head);
			System.out.println("Display Odd Even Node");
			display(prnt);
        }  	
		
		public static Node oddEven(Node head){
			if(head==null || head.next==null) return head;
			Node temp=head;
			Node oddNodeHead=null,oddNodeTail=null,
			evenNodeHead=null,evenNodeTail=null;
			while(null!=temp){
				if(temp.data%2!=0){
					oddNodeTail=new Node(temp.data);
					oddNodeHead=addLast(oddNodeHead,oddNodeTail);
				}else{
					evenNodeTail=new Node(temp.data);
					evenNodeHead=addLast(evenNodeHead,evenNodeTail);
				}
				temp=temp.next;
			}
			oddNodeTail.next=evenNodeHead;
			return oddNodeHead;
		}
		
		public static Node addFirst(Node head,int val){
			Node node=new Node(val);
			if(head==null){
				head=node;
			}else{
				node.next=head;
				head=node;
			}
			return head;
		}
		public static Node addLast(Node head,Node tail){
			if(head==null){
				head=tail;
			}else{
				Node temp=head;
				while(null!=temp && 
					null!=temp.next){
					temp=temp.next;
				}
				temp.next=tail;
			}
			return head;
		}
        public static void display(Node head){
                Node curr=head;
                while(curr!=null){
                   System.out.print(curr.data+" ");
                   curr=curr.next;
            }
            System.out.println(" ");
        }        
}