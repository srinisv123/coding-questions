// Detect if a linked list has a cycle. If so find where the cycle is.
package MyList;
import java.util.HashSet;

class TestCircular {

    public static void main (String arg[]) {

        int [] num = {1,2,3,4,5};
        MyLinkedList head = LinkedListUse.createSampleList(num);
        LinkedListUse.printList(head);
        MyLinkedList cycleNode = isCyclic(head);
        if (cycleNode != null ) {
            System.out.println("Its cyclic and cycle is at: "+cycleNode.data);
        } else {
            System.out.println("Its not cyclic");
        }

        cycleNode = isCyclicWithHash(head);
        if (cycleNode != null ) {
            System.out.println("Hash says cyclic and cycle is at: "+cycleNode.data);
        } else {
            System.out.println("Hash says not cyclic");
        }


        head.next.next.next.next.next = head.next.next;
        cycleNode = isCyclic(head);
        if (cycleNode != null ) {
            System.out.println("Its cyclic and cycle is at: "+cycleNode.data);
        } else {
            System.out.println("Its not cyclic");
        }


        cycleNode = isCyclicWithHash(head);
        if (cycleNode != null ) {
            System.out.println("Hash says cyclic and cycle is at: "+cycleNode.data);
        } else {
            System.out.println("Hash says not cyclic");
        }


        int[] num1 = {1};
        head = LinkedListUse.createSampleList(num1);
        LinkedListUse.printList(head);
        cycleNode = isCyclic(head);
        if (cycleNode != null ) {
            System.out.println("Its cyclic and cycle is at: "+cycleNode.data);
        } else {
            System.out.println("Its not cyclic");
        }


        cycleNode = isCyclicWithHash(head);
        if (cycleNode != null ) {
            System.out.println("Hash says cyclic and cycle is at: "+cycleNode.data);
        } else {
            System.out.println("Hash says not cyclic");
        }


        head.next = head;
        cycleNode = isCyclic(head);
        if (cycleNode != null ) {
            System.out.println("Its cyclic and cycle is at: "+cycleNode.data);
        } else {
            System.out.println("Its not cyclic");
        }


        cycleNode = isCyclicWithHash(head);
        if (cycleNode != null ) {
            System.out.println("Hash says cyclic and cycle is at: "+cycleNode.data);
        } else {
            System.out.println("Hash says not cyclic");
        }


        

        

    }


    public static MyLinkedList isCyclicWithHash(MyLinkedList head) {

        HashSet<MyLinkedList> hash = new HashSet<MyLinkedList>();

        MyLinkedList current = head;
        while (current!=null) {
            if (hash.contains(current)) {
                return current;
            } else {
                hash.add(current);
            } 
            current = current.next;

        }

        return null;
    }


    public static MyLinkedList  isCyclic(MyLinkedList head) {

        int isCyclic = 0;

        MyLinkedList slow = head;
        MyLinkedList fast = head;

        //System.out.println("slow: "+slow.data);
        //System.out.println("         fast: "+fast.data);
        while (true) {


            if (slow == null || fast == null || slow.next ==null ||
                fast.next == null || fast.next.next == null) {
                break;
            }
    
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;

            //System.out.println("slow: "+slow.data);
            //System.out.println("         fast: "+fast.data);

            if (slow == fast) {
                isCyclic = 1;
                break;
            }



        }


        if (isCyclic !=0) {

            slow = head;
            while (slow!=fast) {
                slow=slow.next;
                fast=fast.next;
            }


            return slow;
        } else {
            return null;
        }

    }


}
