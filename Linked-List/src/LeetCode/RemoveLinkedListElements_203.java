package LeetCode;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head. Input:
 * head = [1,2,6,3,4,5,6], val = 6 Output: [1,2,3,4,5]
 */

public class RemoveLinkedListElements_203 {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertAtTail(1);
        singlyLinkedList.insertAtTail(2);
        singlyLinkedList.insertAtTail(6);
        singlyLinkedList.insertAtTail(3);
        singlyLinkedList.insertAtTail(4);
        singlyLinkedList.insertAtTail(5);
        singlyLinkedList.insertAtTail(6);
        SinglyLinkedListNode tempHead = removeElementsRecursion(singlyLinkedList.head, 6);
        printSinglyLinkedList(tempHead);
    }

    public static SinglyLinkedListNode removeElements(SinglyLinkedListNode head, int val) {
        SinglyLinkedListNode currentNode = head;
        SinglyLinkedListNode prevNode = head;
        while (currentNode != null && currentNode.data == val) {
            head = currentNode.next; // Changed head
            currentNode = head;
        }
        while (currentNode != null) {
            if (currentNode.data == val) {
                prevNode.next = currentNode.next;
            } else {
                prevNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    /** One line recursive Solution */
    public static SinglyLinkedListNode removeElementsRecursion(SinglyLinkedListNode head, int val) {
        if (head == null)  return null;
        head.next = removeElementsRecursion(head.next, val);
        return head.data == val ? head.next : head;
    }


    /**print SinglyLinkedlist */
    public static void printSinglyLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "  ");
            currentNode = currentNode.next;
        }
    }
}
