package LinkedIn;
import java.util.HashSet;


class LinkedList {

    int data;
    LinkedList next;
    LinkedList prev;
    
    
    public LinkedList(int data) {
        this.data = data;
        this.next =null;
        this.prev=null;
    }

}


class Sum implements TwoSum {

    // araylist to store the input numbers
    static LinkedList head;
    static LinkedList end;
    
    public void store(int input) {
        // scan the arraylist to insert in the right position
       LinkedList element = new LinkedList(input);
       LinkedList current = head;
       LinkedList last = head;
       
       if (head == null) {
           head = element;
           end = element;
           return;
       }
       
       while(current != null) {
           if (current.data >= input) {
           
               if (current.prev != null) {
                   current.prev.next = element;
                   
               } else {
                  head = element;
               }
               element.prev = current.prev;
               element.next=current;
               current.prev = element;
               break;
          
           }
           last = current;
           current = current.next;
        }
        
        if (current == null) {
            last.next = element;
            element.prev =last;
            end = element;
        
        }
    
    }
    
    public boolean test (int test) {
    
        LinkedList start = head;
        LinkedList finish = end;
        
        boolean exists = false;
        
        while (start != finish && start !=null && finish !=null) {
            if (start.data + finish.data > test) {
                finish =finish.prev;
            } else if (start.data + finish.data < test) {
                start = start.next;
            } else {
                exists = true;
                break;
            
            }
        
        
        }
        
        return exists;
    
    }


}


class HashSum implements TwoSum {

    HashSet<Integer> storage = new HashSet<Integer>();

    public void store(int input) {

       this.storage.add(input); 

    }


    public boolean test(int test) {
        boolean exists = false;
        for (int num : this.storage) {
            if (this.storage.contains(test-num)) { 
                exists = true;
                break;
            }
        }

        return exists;
    }



}






class Linkedin { 


    public static void main(String args[]) {

        Sum sum = new Sum();
        HashSum hashsum = new HashSum();


        sum.store(0);
        hashsum.store(0);

        sum.store(-1);
        hashsum.store(-1);

        sum.store(4);
        hashsum.store(4);
        
        sum.store(5);
        hashsum.store(5);


        if (sum.test(6)) {
            System.out.println("Sum class says: exists");
        }
        else {
            System.out.println("Sum class says: does not exist");
        }

        if (hashsum.test(6)) {
            System.out.println("HashSum class says: exists");
        }
        else {
            System.out.println("HashSum class says: does not exist");
        }
        return;


    }


}
