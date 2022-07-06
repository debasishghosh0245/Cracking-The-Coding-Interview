public class MergeTwoSortedLinkedLists{
    
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
            list1.addLast(10);
            list1.addLast(20);
            list1.addLast(30);
			
            LinkedList list2=new LinkedList();
            list2.addLast(7);
            list2.addLast(9);
            list2.addLast(12);
			
            Node node=meregeRecurrsive(list1.head,list2.head);
            display(node);
        }  

        public static Node merge(Node head1,Node head2){
            //10 20 30 40 50
            //7 9 12 15 37 43 44 48 52 56
            Node temp1=head1;
            Node temp2=head2;
            Node original=new Node(0);
            Node temp=original;
            while(temp1!=null && temp2!=null){
                if(temp1.data < temp2.data){
                    if(temp==null){
                        temp=temp1;
                    }else{
                        temp.next=temp1;
                        temp=temp.next;
                    }
                    temp1=temp1.next;
                }else{
                    if(temp==null){
                        temp=temp2;
                    }else{
                        temp.next=temp2;
                        temp=temp.next;
                    }
                    temp2=temp2.next;
                }
            }
            while(temp1!=null){
                temp.next=temp1;
                temp=temp.next;
                temp1=temp1.next;
            }
            while(temp2!=null){
                temp.next=temp2;
                temp=temp.next;
                temp2=temp2.next;
            }
            return original.next;
        }
		
		//Time Complexcity O(m+n)
		//Space Complexcity O(m+n)
		public static Node meregeRecurrsive(Node head1,Node head2){
			
			if(head1==null) return head2; //very very important place
			if(head2==null) return head1; //very very important place
			
			Node head;
			if(head1.data > head2.data){
				head=head2;
				head2=head2.next;
			}else{
				head=head1;
				head1=head1.next;
			}
			head.next=meregeRecurrsive(head1,head2);
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