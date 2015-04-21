//Write a function to find the intersection of two sorted lists.
// example, intersection([1,2,3], [2,3,4]) = [2,3]
import java.util.ArrayList;
class IntersectionOfTwoLists {


    public static void main(String[] args) {

        int[] list1 = {2,3,4,5};
        int[] list2 = {4,5,6,7};
        ArrayList<Integer> result = findIntersection(list1,list2);
        System.out.println(result.toString());

    }


    public static ArrayList<Integer> findIntersection(int[] list1, int[] list2) {

        int i=0,j=0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(true) {
        
            if (i >=list1.length || j >=list2.length) {
                break;
            }
            if (list1[i] > list2[j]) {
                j++;
            } else if (list1[i] < list2[j]) {
                i++;
            } else {
                result.add(list1[i]);
                i++;j++;
            }
        
        
        }
        
        return result;



    }



}
