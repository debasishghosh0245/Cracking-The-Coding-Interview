public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        singlyLinkedList.insertAtTail(1);
        singlyLinkedList.insertAtTail(2);
        singlyLinkedList.insertAtTail(3);
        singlyLinkedList.insertAtTail(5);

        singlyLinkedList.insertAtHead(10);
        singlyLinkedList.insertAtHead(11);
        singlyLinkedList.insertAtHead(13);
        singlyLinkedList.insertAtHead(12);

        singlyLinkedList.print();

    }
}