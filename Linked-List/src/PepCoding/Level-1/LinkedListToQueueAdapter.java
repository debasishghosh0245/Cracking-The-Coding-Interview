public class LinkedListToQueueAdapter{
     
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
    }

    public int removeFirst(){
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
        return head.data;
    }
    
    public int getFirst(){
         if(head!=null){
             return head.data;
         }else{
             System.out.println("List is Empty");
             return -1;
         }
    }

    public void display(){
            Node curr=head;
            while(curr!=null){
               System.out.print(curr.data+" ");
               curr=curr.next;
            }
    }
   
}   
    
    public static class Queue {
        
        LinkedList list;

        public Queue() {
          list = new LinkedList();
        }

        int size() {
            return list.size;
        }

        void add(int val) {
           list.addLast(val);
        }

        int remove() {
           return list.removeFirst();
        }

        int peek() {
           return list.getFirst();
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
       
        Queue queue=new Queue();
        queue.add(10);
        queue.add(20);
        queue.add(80);
        queue.add(30);
        System.out.println("peek >> "+queue.peek());
        
        queue.remove();
        System.out.println("peek >> "+queue.peek());

    }   
    
}