import java.util.ArrayList;
class GenerateAllCombinations1 {


    public static void main(String[] args) {

        int[] numbers = {1,2,3,4};
        ArrayList<Integer> out = new ArrayList<Integer>();


        generateAllCombinations(numbers, 0, out);


        return;

    }


    public static void generateAllCombinations(int [] numbers, int start, ArrayList<Integer> out ) {
        System.out.println(out.toString());

        for (int i=start; i<numbers.length; i++) {

            out.add(numbers[i]);
            generateAllCombinations(numbers, i+1, out);

            out.remove(out.size()-1);
        }
    }




}
