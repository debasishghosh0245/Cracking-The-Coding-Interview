package LeetCode;

import java.util.*;

public class RemoveDuplicatesFromSortedList_83 {
    public static void main(String[] args) {
        // Input: head = [1,1,2,3,3]
        // Output: [1,2,3]
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(2);
        linkedList.printLinkedList();
        printSinglyLinkedList(deleteDuplicatesWithOutSpace(linkedList.head));
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

    public static SinglyLinkedListNode deleteDuplicatesWithOutSpace(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
        if (head == null)  return null;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.data == currentNode.next.data) {
                currentNode.next = currentNode.next.next;
            }else{
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static SinglyLinkedListNode deleteDuplicatesRecursion(SinglyLinkedListNode head) {
        if (head == null || head.next == null)
            return head;
        head.next = deleteDuplicatesRecursion(head.next);
        return head.data == head.next.data ? head.next : head;
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode temp = node;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }
}
