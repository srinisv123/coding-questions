package MyList;
import java.util.HashSet;

class IntersectingLists {

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


    public static LinkedList getIntersection(LinkedList head1, LinkedList head2) {

        if (head1==null || head2 ==null) 
            return null;
        LinkedList temp = head1;
        
        int list1count=1,list2count=1,diff=0;
        while (temp.next != null) {
            list1count++;
            temp = temp.next;

        }

        LinkedList temp2=head2;
        while(temp2.next!=null) {
            list2count++;
            temp2=temp2.next;
        }

        if (temp!=temp2) {
             return null;
        }

        diff=list1count-list2count;
        temp=head1; // ??
        temp2=head2;
       
        while(diff>0) {
                    temp=temp.next;
                    diff--;
         }


         while(diff<0) {
                temp2=temp2.next;
                diff++;
         }
      


        while(temp !=temp2) {
            temp=temp.next;
            temp2=temp2.next; //??

        }

        return temp;
    }



    public LinkedList getIntersection(LinkedList[] head){
        int len = head.length;
        if (len <=1) {
            return null;
        }
        for (int i=0;i<len;i++){
         if (head[i] ==null)  
            return null;
        }
        
        int[] counts = new int[len];
        //find lenght each list
        LinkedList last = head[0];
        int smallest=findCounts(head[0], last);
        
        for(int i=1;i<len;i++) {
            LinkedList eachLast = head[i];
            counts[i]=findCounts(head[i], eachLast);
            // if any of the last elements is not same, they do not intersect
            if (last != eachLast) return null;

            // update the size of the smallest list
            if (counts[i] < smallest) smallest =counts[i];
        }
        
        int diff =0;
        for (int=0;i<len;i++) {
            
            int diff=counts[i]-smallest;
            while(diff>0) {
                    head[i]=head[i].next;
                    diff--;
             }
        }

        while(!equalHeads(head)) {
            for (int i=0;i<len;i++) {
                head[i] = head[i].next;
            }
           
        }
        return head[0];
    }

    public static int findCounts(LinkedList head, LinkedList temp) {

        int count=1;
        while (temp.next!=null) {
            count++;
            temp=temp.next;
        }
    }

      
    public static boolean equalHeads(LinkedList[] heads) {
       
        for (int i=1;i<heads.length;i++) {
            if (heads[0] != heads[i]) {
                return false;
            }
        }
         return true;
    }


} 
