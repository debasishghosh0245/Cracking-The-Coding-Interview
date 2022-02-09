package LeetCode;

public class RemoveDuplicatesFromSortedListII_82 {
    public static void main(String[] args) {
        // Input: head = [1,2,3,3,4,4,5]
        // Output: [1,2,5]
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(3);
        linkedList.insertAtTail(3);
        linkedList.insertAtTail(4);
        linkedList.insertAtTail(4);
        linkedList.insertAtTail(5);
        linkedList.printLinkedList();
        printLinkedList(deleteDuplicate(linkedList.head));
    }

    public static SinglyLinkedListNode deleteDuplicate(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
       SinglyLinkedListNode prevNode=head;
        while (currentNode != null ) {
            if(currentNode.data==currentNode.next.data) {
                currentNode.next=currentNode.next.next;
            }else{
                prevNode=currentNode;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }
}
