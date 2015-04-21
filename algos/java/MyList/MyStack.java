package MyList;

class MyStack {

    
    private MyLinkedList head;


    public void push(int data) { 

        MyLinkedList newPointer = new MyLinkedList(data);
        newPointer.next = this.head;
        this.head = newPointer;
    }


    public void printStack() {

       LinkedListUse.printList(this.head); 

    }


    public int pop() {
        if (this.head ==null) {
            return -1;
        }

        int data = this.head.data;
        this.head = this.head.next;
        return data;


    }

}



class UseStack {

    public static void main(String[] args) {

        //Create an empty stack
        MyStack stack = new MyStack();

        //Print empty stack
        stack.printStack();

        //pop from empty stack
        int data = stack.pop();
        printData(data);


        //push first element
        stack.push(0);
        System.out.println("First element pushed:");
        stack.printStack();

        // push two more elements
        stack.push(1);
        stack.push(2);
        System.out.println("Pushing two more elements");
        stack.printStack();


        //pop the top element from stack
        printData(stack.pop());
        System.out.println("Stack after popping");
        stack.printStack();

    }


    public static void printData(int data) {
        if (data >=0) {
            System.out.println("Popped elementfrom stack: "+data);
        } else {
            System.out.println("Stack empty, no data");
        }
    }
        

}
