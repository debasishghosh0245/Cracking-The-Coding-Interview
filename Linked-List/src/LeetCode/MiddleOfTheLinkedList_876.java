package LeetCode;

public class MiddleOfTheLinkedList_876 {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(3);
        linkedList.insertAtTail(4);
        linkedList.insertAtTail(5);
        // linkedList.insertAtTail(6);
        SinglyLinkedListNode middleNode = middleNode(linkedList.head);
        printSinglyLinkedList(middleNode);

    }

    public static SinglyLinkedListNode middleNode(SinglyLinkedListNode head) {
        // Eage Cases
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        SinglyLinkedListNode hare = head;
        SinglyLinkedListNode tortoise = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return tortoise;
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "  ");
            currentNode = currentNode.next;
        }
        System.out.println("  ");
    }
}
