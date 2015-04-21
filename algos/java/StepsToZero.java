class StepsToZero {

    public static void main(String[] args) {

        int num = Integer.parseInt(args[0]);

        System.out.println(num);

        stepsToZero(num);

        return;

    }


    public static void stepsToZero(int num) {

        if (num < 0) {
            System.out.println("Invalid num");
            return;
        }

        if (num == 0) {
            System.out.println("Done");
            return;
        }

        if (num == 1) {
            System.out.println("Subtract 1: 1-1 = 0");
            stepsToZero(num-1);
            return ;
        }


        if ((num%2) ==0) {
            System.out.println("Divide by 2: "+num+"/2 = "+(num/2));
            stepsToZero(num/2);

        } else {

            //simpler 
            // If n+1 /2 is even, then do n+1, else do n-1.

            if (powerOfTwo(num-1)) {
                System.out.println("Subtract 1: "+num+"-1 = "+(num-1));
                stepsToZero(num-1);
            } else if (powerOfTwo(num+1)) {
                System.out.println("Add 1: "+num+"+1 = "+(num+1));
                stepsToZero(num+1);
            } else if (multiplicityOfTwo(num+1) > multiplicityOfTwo(num-1)) {
                System.out.println("Add 1: "+num+"+1 = "+(num+1));
                stepsToZero(num+1);
            } else {
                System.out.println("Subtract 1: "+num+"-1 = "+(num-1));
                stepsToZero(num-1);
            }
        }
    }


    public static int multiplicityOfTwo(int num) {
        int multiplicity = 0;

        while ((num%2) == 0) {
            num = num/2;
            multiplicity++;            
        }

        return multiplicity;
    }


    public static boolean powerOfTwo(int num) {
        if ((num & (num-1)) == 0) {
            return true;
        } else {
            return false;
        }

    }

}
