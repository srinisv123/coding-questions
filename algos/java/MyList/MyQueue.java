package MyList;


class MyQueue {

    private MyLinkedList head;
    private MyLinkedList tail;


    public void enQueue(int data) {
        MyLinkedList pointer = new MyLinkedList(data);
        pointer.next = null;
        if (this.head == null || this.tail ==null) {
            this.head = pointer;
            this.tail = pointer;    
            return;
        }

        this.tail.next=pointer;
        this.tail = pointer;
        return;

    }


    public int deQueue() {

        if (this.head==null || this.tail ==null) {
            return -1;
        }

        int data = this.head.data;

        if (this.head == this.tail) {
            this.tail = null;
        }
        this.head = this.head.next;
        return data;
    }


    public void printQueue() {
        System.out.print("head-->");
        MyLinkedList pointer = this.head;
        while(pointer != null) {
            System.out.print(pointer.data+"-->"); 
            pointer = pointer.next;
        }

        System.out.println("tail");

    }

}


class UseQueue {

    public static void main(String[] args) {

        //Create a queue
        MyQueue queue = new MyQueue();

        //print empty queue
        System.out.println("Printing empty queue");
        queue.printQueue();

        //dequeue from an empty queue
        System.out.println("Dequeuing from an empty queue");
        int data = queue.deQueue();
        printItem(data);
        queue.printQueue();

        //enqueuing
        System.out.println("Enqueuing one item");
        queue.enQueue(1);
        queue.printQueue();


        //enqueuing more
        System.out.println("Enqueuing more items");
        queue.enQueue(2);
        queue.printQueue();


        //dequeue the queue fully
        data = queue.deQueue();
        printItem(data);
        queue.printQueue();

        data = queue.deQueue();
        printItem(data);
        queue.printQueue();

        data = queue.deQueue();
        printItem(data);
        queue.printQueue();

    }


    public static void printItem(int data) {
        if(data>=0) {
            System.out.println("DeQueued item: "+data);
        } else {
            System.out.println("null data returned");
        }
    
    }

}
