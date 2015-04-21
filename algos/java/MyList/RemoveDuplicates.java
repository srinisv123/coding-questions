package MyList;
import java.util.HashSet;

class RemoveDuplicates {

    public static MyLinkedList removeDuplicateWithBuffer(MyLinkedList head) {

        HashSet<Integer> hash = new HashSet<Integer>();
        MyLinkedList current = head, prev =null;
        boolean removed =false;
        while (current !=null) {

            if (hash.contains(current.data)) {
                prev.next = current.next;
                removed = true;
            } else {
                hash.add(current.data);
            }

            if (!removed) {
                prev = current;
                removed = false;
            }
            current=current.next;

        }


        return head;


    }


    public static MyLinkedList removeDuplicatesWithoutBuffer(MyLinkedList head) {
        MyLinkedList current = head, duplicate=head, prev=null;
        boolean removed = false;

        while(current!=null) {
            duplicate = head;
            while(duplicate != current) {
                if(duplicate.data == current.data) {
                    prev.next=current.next;
                    removed = true;
                    break;
                }
                duplicate=duplicate.next;
            }
            prev=current;

            if (!removed) {
                current=current.next;
                removed = false;
            }
        }

        return head;
        
    }
    public static void main (String arg[]) {

        int [] num = {1,2,3,4,5,3,2,1,1,7,9};
        MyLinkedList head = LinkedListUse.createSampleList(num);
        LinkedListUse.printList(head);

        head = removeDuplicateWithBuffer(head);
        LinkedListUse.printList(head);

        head = LinkedListUse.createSampleList(num);

        head = removeDuplicateWithBuffer(head);
        LinkedListUse.printList(head);



    }


        

}
