public class SinglyLinkedList {

    public SinglyLinkedListNode head;

    public static class SinglyLinkedListNode {
        SinglyLinkedListNode next;
        int data;

        SinglyLinkedListNode(int data) {
            this.data = data;
        }

    }

    public void insertAtHead(int val) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(val);
        if (null == head) {
            head = newNode;
        } else {
            newNode.next=head;
            head=newNode;
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

    public void print() {
        SinglyLinkedListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "  ");
            currentNode = currentNode.next;
        }
        System.out.println(" ");
    }
}
