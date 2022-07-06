public class MergeKSortedLinkedlist{
    
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
            list1.addLast(1);
            list1.addLast(4);
            list1.addLast(5);
			
            LinkedList list2=new LinkedList();
            list2.addLast(1);
            list2.addLast(2);
            list2.addLast(4);
			
			LinkedList list3=new LinkedList();
            list3.addLast(2);
            list3.addLast(6);
			
			ListNode[] listnodes={list1.head,list2.head,list3.head};
			
            ListNode ListNode=mergeKLists(listnodes);
            display(ListNode);
        }  

        public ListNode mergeKLists(ListNode[] lists) {
			return null;
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