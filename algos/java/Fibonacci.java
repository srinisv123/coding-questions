// Generate the nth fibonacci number
import java.math.BigInteger;
class Fibonacci {


    public static void main(String[] args) {

        int n=Integer.parseInt(args[0]);
        fibonacci(n);

    }


    public static void fibonacci(int n) {

        if (n<0) {
            System.out.println("Invalid input");
            return;
        }


        if (n==0 || n==1) {
            System.out.println(1);
            return;
        }

        BigInteger n_1= new BigInteger("1"), n_2= new BigInteger("1"),fib= new BigInteger("0");
        for (int i=2; i<=n; i++) {
            fib = n_1.add(n_2);
            n_1=n_2;
            n_2=fib;
        }
        System.out.println(fib);

        return;

    }


}


