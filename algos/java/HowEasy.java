class HowEasy {
    public int pointVal(String problemStatement) {

        
        problemStatement += " ";
        char[] letters = problemStatement.toCharArray();

        int numOfWords = 0;
        boolean isWord = true;
        int numOfChars = 0;
        int numOfWordChars  = 0;
        int len = letters.length;
        for(int i=0; i<len; i++) {
            System.out.println(letters[i]);

            if (letters[i]==' ') {
                if (i!=0 && isWord && letters[i-1] != ' ') {
                    numOfWords++;
                    numOfChars += numOfWordChars;
                }
                numOfWordChars = 0;
                isWord=true;
                continue;
            }

            if (letters[i] == '.') {
                if (letters[i+1] != ' ') {
                   isWord = false;
                   numOfWordChars =0;
                }
                continue;

            }

            if ((letters[i]>= 'a' && letters[i] <= 'z') || (letters[i] >='A' && letters[i] <='Z')) {
                numOfWordChars++;
                continue;
            }

            isWord = false;
            numOfWordChars = 0;

        }

        int avg =0;

        if (numOfWords != 0) {
            avg = numOfChars/numOfWords;
        }


        if (avg<=3) {
            return 250;
        } else if (avg>=4 && avg <=5) {
            return 500;
        } else {
            return 1000;
        }            


        

    }


    public static void main(String arg[]) {

        HowEasy howeasy = new HowEasy();
        int avg = howeasy.pointVal("abcd ..");
        System.out.println("Points: "+avg);
    }

}
