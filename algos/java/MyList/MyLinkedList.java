package MyList;

import java.lang.System;

class MyLinkedList {

    // data
    int data;

    // the next pointer
    MyLinkedList next;

    //constructor
    public MyLinkedList(int num) {
        this.data = num;
    }

}


class LinkedListUse {

    public static void main(String[] args) {

        // Create a new list and print it
        int[] num = {1,2,3,5,6,7};
        System.out.println("Original List:");
        MyLinkedList head = createSampleList(num);
        printList(head);

        // Insert the value 4 at the 4th position
        System.out.println("Insert 4 into 4th position: ");
        head = insertIntoList(head, 4, 4);
        printList(head);

        // Insert into the head
        System.out.println("Insert 0 into head position: ");
        head = insertIntoList(head, 0, 1);
        printList(head);

        // Insert into last position
        System.out.println("Insert 8 into 9th position: ");
        head = insertIntoList(head, 8, 9);
        printList(head);

        // Insert into an invalid position
        System.out.println("Insert 9 into 19th position: ");
        head = insertIntoList(head, 9, 19);
        printList(head);

        // Delete from an intermediate position
        System.out.println("Delete the value 7");
        head = deleteAValueFromList(head,7);
        printList(head);

        // Delete from last position
        System.out.println("Delete the value 8");
        head = deleteAValueFromList(head,8);
        printList(head);

        // Delete the head
        System.out.println("Delete the value 0");
        head = deleteAValueFromList(head,0);
        printList(head);

        // Get mth to last element
        System.out.println("Get the last 4th element");
        MyLinkedList mthTolast  = mthToLastElement(head,4);
        printList(mthTolast);

        // Get mth to last element
        System.out.println("Get the last 2nd element");
        mthTolast  = mthToLastElement(head,2);
        printList(mthTolast);

        // Get mth to last element
        System.out.println("Get the last element");
        mthTolast  = mthToLastElement(head,1);
        printList(mthTolast);

        // Get mth to last element
        System.out.println("Get an invalid element");
        mthTolast  = mthToLastElement(head,10);
        printList(mthTolast);

        // Create lists for reversal
        int[] num = {};
        MyLinkedList head = createSampleList(num);
        System.out.println("Original List: ");
        printList(head);
        System.out.println("Reverse List: ");
        printList(reverseList(head));

        // Create lists for reversal
        int[] num = {1};
        MyLinkedList head = createSampleList(num);
        System.out.println("Original List: ");
        printList(head);
        System.out.println("Reverse List: ");
        printList(reverseList(head));

        // Create lists for reversal
        int[] num = {1,2};
        MyLinkedList head = createSampleList(num);
        System.out.println("Original List: ");
        printList(head);
        System.out.println("Reverse List: ");
        printList(reverseList(head));

        // Create lists for reversal
        int[] num = {1,2,3};
        MyLinkedList head = createSampleList(num);
        System.out.println("Original List: ");
        printList(head);
        System.out.println("Reverse List: ");
        printList(reverseList(head));

        // Create lists for reversal
        int[] num = {1,2,3,4,5,6};
        MyLinkedList head = createSampleList(num);
        System.out.println("Original List: ");
        printList(head);
        System.out.println("Reverse List: ");
        printList(reverseList(head));

        return;
    
        
    }



    public static MyLinkedList mthToLastElement(MyLinkedList head, int position) {

        if (head==null || position<=0) {
            return null;
        }

        MyLinkedList slow = head;
        MyLinkedList fast = head;

        // Move the fast pointer to m positions
        for (int i=1; i<position;i++) {
            fast = fast.next;
            if (fast == null) {
                System.out.println("List size is lesser than m");
                return null;
            }
        }

        // move the slow and fast pointer together
        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

        
       
    }


    // A function to delete an element from linked list
    public static MyLinkedList deleteAValueFromList(MyLinkedList head, int value) {

        // If head is empty return null
        if (head == null) {
            return null;
        }

        // if the value to be deleted is the first one
        if (value == head.data) {
            head = head.next;
            return head;
        }

        // start from the second item
        MyLinkedList pointer = head.next;
        MyLinkedList prev = head;

        while (pointer != null) {

            if (pointer.data == value) {
                prev.next = pointer.next;
                return head;
            }

            prev = pointer;
            pointer = pointer.next;

        }
        return head;

    }



    //Insert into any position in the linked list
    public static MyLinkedList insertIntoList(MyLinkedList head, int value, int position) {
        
        // invlaid position
        if (position <=0 ) {
            return null;
        }

        // Create the new linked list item
        MyLinkedList newPointer = new MyLinkedList(value);

        // If we need to insert in the head or if the original list was empty
        if (position ==1 || head == null) {
            newPointer.next = head;
            head = newPointer;
            return head;
        }


        MyLinkedList pointer = head;
        for(int i=0; i<position-2; i++) {
            pointer = pointer.next;
            if (pointer == null) {
                System.out.println("Invalid position");
                return head;
            }
            
        }

        newPointer.next = pointer.next;
        pointer.next = newPointer;

        return head;
    }



    // Create a linked list with an integer array as param
    public static MyLinkedList createSampleList(int[] num) {
        int count = num.length;
        if (count <= 0) {
            return null;
        }
        MyLinkedList head = new MyLinkedList(num[0]);
        head.next = null;

        MyLinkedList prev = head;
        for (int i=1; i<count; i++) {
           MyLinkedList pointer = new MyLinkedList(num[i]);
            
           prev.next = pointer;
           pointer.next = null;
           prev = pointer;

        }


        return head;

    }


    public static MyLinkedList reverseList(MyLinkedList head) {

        if (head == null) {
            return head;
        }

        MyLinkedList current = head;
        MyLinkedList next = head.next;
        current.next = null;

        MyLinkedList temp = head.next;
        while (next != null) {
            temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }

        head = next;
        return head;
    }


    // print a list given the head pointer
    public static void printList(MyLinkedList head) {
        MyLinkedList pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data+"-->");
            pointer = pointer.next;
        }
        System.out.print("null\n");
        return;

    }




}
