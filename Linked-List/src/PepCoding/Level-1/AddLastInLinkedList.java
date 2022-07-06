public class AddLastInLinkedList {
     
    public static class LinkedList {
     
        public Node head;
        public Node tail;
        public int size;
        
        
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
        
      public void addFirst(int val) {
          Node temp=new Node(val);
          temp.next=this.head;
          this.head=temp;
      }
   
        public void display(){
           Node curr=head;
           while(curr!=null){
               System.out.print(curr.data+" ");
               curr=curr.next;
           }
        }
    }

    private static class Node{
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
       linkedList.addLast(5);
       linkedList.addLast(10);
       linkedList.addLast(15);
       linkedList.addLast(20);
       linkedList.addLast(25);
       linkedList.display();
       
       System.out.println("Size >>"+linkedList.size);
       System.out.println("tail >> "+linkedList.tail.data);
       
   }   
    
}