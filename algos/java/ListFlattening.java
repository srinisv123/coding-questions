class ListFlattening {

    int data;
    ListFlattening next;
    ListFlattening prev;
    ListFlattening child;

    public ListFlattening(int data) {
        this.data = data;
    }

    public static void main(String[] args) {

        ListFlattening top1 = new ListFlattening(1);
        ListFlattening top2 = new ListFlattening(2);
        ListFlattening top3 = new ListFlattening(3);
        ListFlattening mid1 = new ListFlattening(4);
        ListFlattening mid2 = new ListFlattening(5);
        ListFlattening mid3 = new ListFlattening(6);
        ListFlattening bot1 = new ListFlattening(7);
        ListFlattening up1 = new ListFlattening(8);
        ListFlattening up2 = new ListFlattening(9);

        top1.prev = null;
        top1.next = top2;
        top1.child = mid1;

        top2.prev = top1;
        top2.next = top3;
        top2.child = up1;
        
        top3.prev = top2;
        top3.next = null;


        mid1.prev = null;
        mid1.next = mid2;
    
        mid2.prev = mid1;
        mid2.next = mid3;
        mid2.child = bot1;

        mid3.prev = mid2;
        mid3.next = null;

        bot1.next = null;
        bot1.prev = null;

        up1.prev = null;
        up1.next = up2;
        up1.child = null;

        up2.prev = up1;
        up2.next = null;
        up2.child = null;

        printList(top1);

        top1 = flatten(top1, top3);
        printList(top1);


        


    }


    public static void printList(ListFlattening head) {

        ListFlattening pointer = head;
        while(pointer != null) {
            System.out.print(pointer.data+"<=>");
            pointer = pointer.next;
        }

        System.out.println("null");

    }



    public static ListFlattening flatten(ListFlattening head, ListFlattening tail) {

        ListFlattening pointer = head;

        while (pointer != null) {
            if (pointer.child != null) {

                //find the tail of child list
                ListFlattening newPointer = pointer.child;
                while(newPointer.next != null) {
                    newPointer = newPointer.next;
                }
                
                tail.next = pointer.child;
                pointer.child.prev = tail;

                tail = newPointer;
                

            }

            pointer = pointer.next;


        }


        return head;



    }
}
