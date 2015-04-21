import java.util.Arrays;
class GenerateAllPhoneWords {


    public static void main (String[] args) {

        int[] num = {5,5,9,2,9,9,2};
        char[] out = new char[num.length];
        generateAllPhoneWords(num, 0,out);


    }



    public static void generateAllPhoneWords(int[] number, int pos, char[] out) {


        if (pos >= (number.length)) {
            System.out.println(out);
            return;
        }
        for(int i=0; i<3; i++) {
            // 9 has only 2 chars
            if (number[pos] == 9 && i ==2)  return;
            out[pos] = getCharacter(number[pos],i);
            generateAllPhoneWords(number, pos+1, out);
            // 0 needs to be checked only once
            if (number[pos] == 0) return;
        }
    }


    public static char getCharacter(int num, int pos) {

        if (num ==0) return '0';

        char[][] telephoneChars = 
                    {{'a','b','c'},
                    {'d','e','f'},
                    {'g','h','i'},
                    {'j','k','l'},
                    {'m','n','o'},
                    {'p','q','r'},
                    {'s','t','u'},
                    {'v','w','x'},
                    {'y','z'}};


        return telephoneChars[num-1][pos];
    }



}
