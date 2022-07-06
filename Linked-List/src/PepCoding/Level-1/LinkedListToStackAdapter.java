public class LinkedListToStackAdapter{
     
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

    public static class Stack {
        LinkedList list;
        public Stack() {
          list = new LinkedList();
        }
        int size() {
          return list.size;
        }
        void push(int val) {
           list.addLast(val);
        }
        int pop() {
            return list.removeLast();
        }
        int top() {
           return list.getLast();
        }
  }

   public static void main(String[] args) {
       
        Stack stack=new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        System.out.println("Topped >> "+stack.top());
        stack.pop();
        System.out.println("Topped >> "+stack.top());
   }   
    
}