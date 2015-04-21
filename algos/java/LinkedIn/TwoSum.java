package LinkedIn;

public interface TwoSum {
    /**
     * Stores @param input in an internal data structure.
     */
    public void store(int input);
 
    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param test, and false otherwise.
     * For example, if the numbers 3, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     */
    public boolean test(int test);
}


