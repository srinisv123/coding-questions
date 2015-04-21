class BestStockBuy {


    public static void main(String args[]) {

        int len = Integer.parseInt(args[0]);
        int[] array = new int[len];
        for (int i=0; i<len; i++) {
            array[i] = Integer.parseInt(args[i+1]);
        }

        int[] bestBuy = bestStockBuy(array);

        System.out.println("Buy on day: "+bestBuy[0]+" and sell on day: "+bestBuy[1]);


        System.out.println("More efficient: ");
        findOptimalBuySell(array, len);

        return;



    }


   
    public static void findOptimalBuySell(int[] array, int length) {

        if (length ==0) {
             System.out.println("No values in array");
             return;
        }

        int currentMin=0, globalMax=0, globalDiff=0, globalMin=0;
        for(int i=1; i< length; i++) {
            if((array[i]-array[currentMin]) > globalDiff) {
            
                globalMin = currentMin;
                globalMax = i;
                globalDiff = array[i]-array[currentMin];
            } 
                
            if (array[i] <= array[currentMin]) {
                currentMin =i;
            }

        }
        
        System.out.println("Buy date: "+globalMin+" sell date: "+globalMax);
        return;


    }

 



    public static int[] bestStockBuy(int[] array) {

        int globalMin = 0, globalMax=0, globalDiff =0;
        int currMin=0;
        for (int i=1; i<array.length; i++) {
            if (array[i]>array[i-1]) {
                if ((array[i]-array[currMin]) > globalDiff) {
                    globalMin = currMin;
                    globalMax = i;
                    globalDiff = array[i]-array[currMin];
                }

            } else if (array[i] <array[i-1]) {
                if (array[i] <=array[currMin]) {
                    currMin = i;
                } 
            }
        }

        int [] result = {globalMin,globalMax};
        return result;
    }




}
