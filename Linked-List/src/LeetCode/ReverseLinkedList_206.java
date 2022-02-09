package LeetCode;

public class ReverseLinkedList_206 {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(3);
        linkedList.insertAtTail(4);
        linkedList.insertAtTail(5);
        SinglyLinkedListNode revNode = reverseList(linkedList.head);
        printLinkedList(revNode);
    }

    // Iterative appraoch
    public static SinglyLinkedListNode reverseList(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
        SinglyLinkedListNode prevNode = null;
        SinglyLinkedListNode nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next; // 2 //3
            currentNode.next = prevNode; // null >1
            prevNode = currentNode; // 2
            currentNode = nextNode; // 3
        }
        return prevNode;
    }

    // recursive appraoch //less code // 
    public static SinglyLinkedListNode reverseListRecursive(SinglyLinkedListNode head) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tempNode = newNode;
        if (head == null)  return null;
        reverseListRecursive(head.next);
        tempNode.next = head;
        tempNode = tempNode.next;
        return newNode;
    }

    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
        while (null != currentNode) {
            System.out.print(currentNode.data + "  ");
            currentNode = currentNode.next;
        }
    }
}
