package LeetCode;

import java.util.*;

public class RemoveDuplicatedFromUnsortedList_1836 {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(3);
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(3);
        linkedList.printLinkedList();
        printSinglyLinkedList(deleteDuplicateIterative(linkedList.head));
    }

    public static SinglyLinkedListNode deleteDuplicates(SinglyLinkedListNode head) {
        Set<Integer> set = new HashSet<>();
        SinglyLinkedListNode currentNode = head;
        SinglyLinkedListNode prevNode = head; // 1
        while (null != currentNode) {
            if (set.contains(currentNode.data)) {
                prevNode.next = currentNode.next; // 2
            } else {
                prevNode = currentNode; // 2
            }
            set.add(currentNode.data); // 1 //2
            currentNode = currentNode.next; // 2 2 //3
        }
        return head;
    }

    public static SinglyLinkedListNode deleteDuplicateIterative(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
        while (currentNode != null) {
            SinglyLinkedListNode tempNode = currentNode;
            while (tempNode != null) {
                if (tempNode.next != null && currentNode.data == tempNode.next.data) {
                    tempNode.next = tempNode.next.next;
                } else {
                    tempNode = tempNode.next;
                }
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode temp = node;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }
}
