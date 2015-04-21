/* Given an integer, print the numbers in gray code format
*  i.e. successive numbers duiffer only by 1 bit
*  E.g:  n=3
*        0 0 0
*        0 0 1
*        0 1 1
*        0 1 0
*        1 1 0
*        1 1 1
*        1 0 1
*        1 0 0
*/

class GrayCode {


    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        changeBit("",n, true);

    }


    public static void changeBit(String prefix, int n, boolean dir) {

        if (n==0) {
            System.out.println(prefix);
            return;
        }

        if (dir) {
            
            changeBit(prefix+"0",n-1,true);
            changeBit(prefix+"1",n-1,false);
        } else {
            changeBit(prefix+"1",n-1,true);
            changeBit(prefix+"0",n-1,false);
        }

        return;


    }


}
