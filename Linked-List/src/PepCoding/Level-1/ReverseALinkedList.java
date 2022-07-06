public class ReverseALinkedList{
     
    public static class LinkedList {
        public Node head;
        public Node tail;
        public int size;

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
   
    public void display(){
            Node curr=head;
            while(curr!=null){
               System.out.print(curr.data+" ");
               curr=curr.next;
            }
    }
    
    public void reverse(){
        Node prev=null;
        Node curr=head;
        while(null!=curr){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
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
        linkedList.addFirst(20);
        linkedList.addFirst(80);
        linkedList.addFirst(30);
        linkedList.addFirst(40);
        linkedList.addFirst(50);
        linkedList.display();
        linkedList.reverse();
        System.out.println("");
        linkedList.display();
   }   
    
}