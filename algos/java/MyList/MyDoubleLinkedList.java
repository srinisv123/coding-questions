//Create a double linked liked list

package MyList;


class DoubleLinkedList {

    int data;
    DoubleLinkedList next;
    DoubleLinkedList prev;

    public DoubleLinkedList(int data, DoubleLinkedList next, DoubleLinkedList prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DoubleLinkedList(int data) {
        this(data, null, null);
    }
        

}


class DoubleLinkedListUse {



    public static void main(String[] args) {
    
        DoubleLinkedList temp =null
        DoubleLinkedList temp1 = new DoubleLinkedList(11);
        for (int i = 10 ;i > =0 ; i-- ) {
            temp = new DoubleLinkedList(i, temp1, null)
            temp1 = temp;
        }

        DoubleLinkedList head = temp;

        temp1.next.prev = temp1.next.next;
        System.out.println("head: " + head.data);
        if (head.next ==null) {
            System.out.println("head's next is null");
        }


    }


    public static DoubleLinkedList duplicateDoubleListWithRandomBackPointers(DoubleLinkedList head) {

        DoubleLinkedList temp = head;
        DoubleLinkedList duplicate;

        while (temp != null) {
            duplicate = new DoubleLinkedList(temp.data, temp.next, temp.prev);
            temp.next = duplicate;
            temp = temp.next.next;
        }

        temp = head;
        while (temp != null) {
            duplicate = temp.next;
            if (temp.prev !=null) {
                duplicate.prev = temp.prev.next;
            }
        }

        temp = head;
        DoubleLinkedList head2 = temp != null ? temp.next : null;
        DoubleLinkedList temp2 = head2;
        while (temp != null) {
            temp.next = temp.next.next;
            if (temp2.next ! = null) {
                temp2.next = temp2.next.next;
            }
        }

        return head2;
            

    }



}
