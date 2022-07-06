public class AddAtIndexInLinkedList {
     
    public static class LinkedList {
        public Node head;
        public Node tail;
        public int size;
         
    public void addAt(int idx, int val){
        Node temp=new Node(val);
        if(head==null) {
            head=temp;
            tail=temp;
            size++;
        }
        else{
            Node curr=head;
            while(curr.next!=null && idx!=0) {
                curr=curr.next;
                idx--;
            }
            if(curr!=null && curr.next!=null) {
               temp.next=curr.next.next; 
            }else{
               temp.next=null;
            }
            curr.next=temp;
            size++;
        }
    }
    
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
           //return head;
   }
   
   public void display(){
           Node curr=head;
           while(curr!=null){
               System.out.print(curr.data+" ");
               curr=curr.next;
           }
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
       linkedList.addAt(0,10);
       linkedList.addAt(1,20);
       linkedList.addLast(80);
       linkedList.addAt(2,30);
       linkedList.addAt(3,40);
       linkedList.addFirst(50);
       linkedList.display();
       
       System.out.println("size >> "+linkedList.size);
       System.out.println("tail node >> "+linkedList.tail.data);
       
   }   
    
}