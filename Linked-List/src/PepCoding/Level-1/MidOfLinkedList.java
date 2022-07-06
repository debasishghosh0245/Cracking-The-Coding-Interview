public class MidOfLinkedList{
     
    public static class LinkedList {
        private Node head;
        private Node tail;
        private int size;
        
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
    public int removeLast() {
        Node temp=head;
        while(temp.next.next!=null) {
            temp=temp.next;
        }
        if(null!=temp){
            temp.next=null;
            tail=temp;
        }
        size--;
        return temp.data;
    }
   
    public void display(){
        Node curr=head;
        while(curr!=null){
           System.out.print(curr.data+" ");
           curr=curr.next;
        }
        System.out.println(" ");  
    }
    
    
    public int mid(){
        Node fast=head;
        Node slow=head;
        while(null!=slow && null!=fast 
        && null!=fast.next && null!=fast.next.next){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
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
       
        LinkedList list=new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        
        list.display();
        
        System.out.println("Print middle data>> "+list.mid());
        
   
    }   
    
}