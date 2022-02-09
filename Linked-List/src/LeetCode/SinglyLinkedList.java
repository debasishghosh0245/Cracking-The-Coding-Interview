package LeetCode;

public class SinglyLinkedList {

    public SinglyLinkedListNode head;

    public void insertAtHead(int val) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(val);
        if (null == head) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtTail(int val) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(val);
        if (null == head) {
            head = newNode;
        } else {
            SinglyLinkedListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;
        }
    }

    public void printLinkedList() {
        SinglyLinkedListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "  ");
            currentNode = currentNode.next;
        }
        System.out.println(" ");
    }

    public void insertAtTail(SinglyLinkedListNode node) {
        if (head == null) {
            head = node;
        } else {
            SinglyLinkedListNode lastNode = head;
            while (lastNode != null && lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
    }
}
