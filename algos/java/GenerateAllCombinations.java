import java.util.ArrayList;
class GenerateAllCombinations {


    public static void main(String[] args) {

        int[] numbers = {1,2,3,4};
        ArrayList<Integer> out = new ArrayList<Integer>();

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();


        generateAllCombinations(numbers, 0, out, result);


        for(ArrayList list : result) {
            System.out.println(list.toString());
        }

        return;

    }


    public static void generateAllCombinations(int [] numbers, int start, ArrayList<Integer> out, ArrayList<ArrayList<Integer>> result) {

        int len = numbers.length;
        for (int i=start; i<len; i++) {

            out.add(numbers[i]);
            result.add(new ArrayList<Integer>(out));
            generateAllCombinations(numbers, i+1, out, result);

            out.remove(out.size()-1);
        }
    }




}
