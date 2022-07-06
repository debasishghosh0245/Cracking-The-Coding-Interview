public class GetValueInLinkedList {
     
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
        else {
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
   }
   
    public void removeAt(int idx) {
        Node temp=head;
        if(idx==0){
            head=head.next;
        }else{
            while(temp.next!=null && idx!=1) {
                temp=temp.next;
                idx--;
            }
            if(null!=temp){
                temp.next=temp.next.next;
            } 
        }
        size--;
    }
    
    public int getAt(int idx) {
        Node temp=head;
        while(temp.next!=null && idx!=0){
            temp=temp.next;
            idx--;
        }
        if(temp!=null){
           return temp.data; 
        }else{
            System.out.println("List is Empty");
            return -1; 
        }
    }
    
    public int getFirst(){
         if(head!=null){
             return head.data;
         }else{
             System.out.println("List is Empty");
             return -1;
         }
    }
    
    public int getLast(){
        Node temp=head;
        while(temp.next!=null) {
            temp=temp.next;
        }
        if(temp!=null){
            return temp.data;
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
        
        System.out.println("Frist >> "+linkedList.getFrist());
        System.out.println("Last >> "+linkedList.getLast());
        System.out.println("At Index >>"+linkedList.getAt(2));
       
   }   
    
}