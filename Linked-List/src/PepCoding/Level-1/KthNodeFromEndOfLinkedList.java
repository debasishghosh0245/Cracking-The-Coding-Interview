public class KthNodeFromEndOfLinkedList{
     
    public static int idx=0;
    public static int deleted;
    
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

    //approach 1
    public int removeKthNode(int k){
        Node temp=head;
        int del;
        for(int i=1;i<size-k;i++){
            temp=temp.next;
        }
        del=temp.next.data;
        temp.next=temp.next.next;
        return del;
    }
    
    //approach 2 :: recurive
    public Node removeKthNodeRe(int k,Node head){
        if(head==null || head.next==null) return head;
        removeKthNodeRe(k,head.next);
        idx++;
        if(k==idx){
            deleted=head.next.data;
            head.next=head.next.next;
        }
        return head;
    }
    
    //approach 3
    public Node removeKthNodeB(int k) {
        Node fast=head;
        Node slow=head;
        while(k!=0){
            k--;
            fast=fast.next;
        }
        while(null!=fast && 
            fast.next!=null) {
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
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
        System.out.println(list.removeKthNodeB(3));
        list.display();
        System.out.println("deleted << "+deleted);
        
    }   
}