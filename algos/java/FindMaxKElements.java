import java.util.PriorityQueue;
class FindMaxKElements {


    public static void main (String[] args) {

        int [] array = {23,34,24,90,87,68,56,89,46,35,20,7,6,2,8,29};
        
        maxKElements(array,5);


    }



    public static void maxKElements(int[] elements, int k) {

        PriorityQueue<Integer> topK = new PriorityQueue<Integer>();
        for(int i: elements) {
            topK.add(i);
            if (topK.size() > k) {
                topK.poll();
            }
        }

        while(topK.size() >0) {
            System.out.print(topK.poll()+" ");
        }
    }



}
