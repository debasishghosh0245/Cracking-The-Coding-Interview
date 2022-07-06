public class AddFirstInLinkedList {
     
    public static class LinkedList {
        public Node head;
        public Node tail;
        public int size;
         
    public void addFirst(int val) {
          Node temp=new Node(val);
          if(head==null){
              head=temp;
              tail=temp;
          }else{
             temp.next=this.head;
             this.head=temp; 
          }
          size++;
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
       linkedList.addFirst(10);
       linkedList.addFirst(10);
       linkedList.addFirst(15);
       linkedList.addFirst(20);
       linkedList.addFirst(25);
       linkedList.display();
       System.out.println("Size >>"+linkedList.size);
       System.out.println("tail >> "+linkedList.tail.data);
       
   }   
    
}