package Java.linkedList;

public class LinkedList{
    ListNode head;

    // Constructor to create an empty LinkedList
    public LinkedList() {
        this.head = null;
    }

    
    
    //function to insert a new node at the begining
    public void insertAtBeginning(int data){
        ListNode node = new ListNode(10);
        node.next = head;
        head = node;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert after a given node
    public void insertAfterNode(ListNode prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        ListNode newNode = new ListNode(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Delete from the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete after a given node
    public void deleteAfterNode(ListNode prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("The given node is null or there is no node to delete after the given node");
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    // Traverse the list
    public void traverse() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Search for a node
    public boolean search(int key) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Update a node's value
    public void updateNode(int oldValue, int newValue) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.data == oldValue) {
                temp.data = newValue;
                return;
            }
            temp = temp.next;
        }
    }

    // Reverse the list
    public void reverse() {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Main method to test the LinkedList operations
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtBeginning(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAfterNode(list.head, 4);

        list.traverse();

        list.deleteFromBeginning();
        list.traverse();

        list.deleteFromEnd();
        list.traverse();

        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.deleteAfterNode(list.head);
        list.traverse();

        System.out.println(list.search(5));
        System.out.println(list.search(7));

        list.updateNode(5, 9);
        list.traverse();

        list.reverse();
        list.traverse();
    }
}

class ListNode {
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
