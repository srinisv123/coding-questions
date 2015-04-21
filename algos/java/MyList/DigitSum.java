package MyList;
class DigitSum {

    public static void main (String[] args) {

        int[] num1 = {2,4,5};
        int[] num2 = {2,4,5};

        MyLinkedList head1 = LinkedListUse.createSampleList(num1);
        LinkedListUse.printList(head1);
        MyLinkedList head2 = LinkedListUse.createSampleList(num2);
        LinkedListUse.printList(head2);

        MyLinkedList sum = digitSum(head1,head2);
        LinkedListUse.printList(sum);


        return;


        



    }




    public static MyLinkedList digitSum(MyLinkedList num1, MyLinkedList num2) {

        MyLinkedList result = null, current =null;
        int carry = 0;

        while(num1!=null || num2!=null) {

            int sum =carry;
            if (num1!=null) {
                sum += num1.data;
                num1 =num1.next;
            }

            if (num2!=null) {
                sum += num2.data;
                num2 = num2.next;
            }

            if (sum >=10) {
                sum = sum%10;
                carry =1;
            } else {
                carry=0;
            }


            MyLinkedList node = new MyLinkedList(sum);
            if (result == null) {
                result =node;
                current=node;
            } else {
                current.next = node;
                current = node;
            }


        }


        if (carry!=0) {
            MyLinkedList node = new MyLinkedList(carry);
            current.next = node;
        }


        return result;

    }

}
