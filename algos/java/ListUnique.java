//2 integer lists, returns all elements in first that are noth in second
//output shd not have duplicates
import java.util.HashSet;
class ListUnique {

    public static void main(String[] args) {
        int[] list1 = {2,4,5,2,5,6,12,34};
        int[] list2 = {2,7,18,23,34};

        listUnique(list1,list2); 
        System.out.print("\n");




    }   


    public static void listUnique(int[] list1, int[] list2) {

        HashSet<Integer> set = new HashSet<Integer>();


        for (int num: list2) {
            set.add(num);
        }

        for (int num: list1) {
            if (!set.contains(num)) {
                System.out.print(num+" ");
                set.add(num);
            }
        }

        return;

    }
}
