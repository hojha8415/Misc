import java.util.Scanner;

public class DeleteLinkedListElement {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        // Create a linked list
        Scanner scanner = new Scanner(System.in);
        System.out.print("What's the size of the list? ");
        int size = scanner.nextInt();
        System.out.println("You entered the size as - " + size);
        Node head = null;
        System.out.println("Enter the head node value - ");
        int headValue = scanner.nextInt();
        if (head == null) {
            head = new Node(headValue);
        }
        Node temp = head;
        System.out.println("Enter the remaining node values - ");
        for (int i = 1; i < size; i++) {
            int inputVal = scanner.nextInt();
            temp.next = new Node(inputVal);
            temp = temp.next;
        }

        System.out.print("Initial LinkedList: ");
        displayList(head);

        System.out.print("Enter the element to be deleted: ");
        int elementToDelete = scanner.nextInt();

        System.out.print("Delete only the first occurrence? (true/false): ");
        boolean deleteFirstOccurrence = scanner.nextBoolean();

        //calling the method to delete the element from the LinkedList
        head = deleteElement(head, elementToDelete, deleteFirstOccurrence);

        System.out.print("Modified LinkedList: ");
        displayList(head);
    }
    private static void displayList(Node head) {
        Node iterator = head;
        while (iterator != null) {
            System.out.print(iterator.data + "->");
            iterator = iterator.next;
        }
        System.out.println("null");
    }
    private static Node deleteFirstOccurrence(Node head, int element) {
        Node dummy = new Node(0); //dummy node to simplify deletion at the beginning
        dummy.next = head;
        Node curr = dummy;
        Node prev = null;

        while (curr != null) {
            if (curr.data == element) {
                if (prev == null) {
                    dummy.next = curr.next;
                } else {
                    prev.next = curr.next;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        return dummy.next; // return the modified list, excluding the dummy node
    }
    private static Node deleteAllOccurrences(Node head, int element) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node curr = dummy;
        Node prev = null;

        while (curr != null) {
            if (curr.data == element) {
                if (prev == null) {
                    dummy.next = curr.next;
                } else {
                    prev.next = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
    private static Node deleteElement(Node head, int element, boolean deleteFirstOccurrence) {
        if (deleteFirstOccurrence) {
            return deleteFirstOccurrence(head, element);
        } else {
            return deleteAllOccurrences(head, element);
        }
    }
}
