public class BitChanger
{

    public static void changeBits(int pos, char[] bits, boolean order)
    {
        if(pos < 0)
        {
            return;
        }
        if(pos >= bits.length)
        {
            System.out.println(bits);
        }
        else
        {
            if(order)
            {
                bits[pos] = '0';
                changeBits(pos+1, bits, order);

                bits[pos] = '1';
                changeBits(pos+1, bits, !order);
            }

            if(!order)
            {
                bits[pos] = '1';
                changeBits(pos+1, bits, !order);

                bits[pos] = '0';
                changeBits(pos+1, bits, order);
            }
        }
    }

    public static void main(String[] args)
    {
        char[] arr = new char[4];
        changeBits(0, arr, true);
    }
}

