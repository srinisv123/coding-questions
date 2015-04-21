import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashSet;


class Spreadsheet {

	private String[] spreadSheet;
    
    // Creating a new array of float to store the floating point values instead
    // of strings. 
    private Float[] spreadSheetValue;
	private int width;
	private int height;

    public static void main(String[] args) {


        Spreadsheet sheet = new Spreadsheet();

		// read input from stdin and store them in a spreadsheet
        sheet.readInput();  

        // do a second pass to evaluate the data and print
		sheet.evaluate();
 
    }

	/**
	* Function readInput will read through the input and  add it to the internal
	* spreadsheet datastructure
	*/
    public void readInput() {


        try {
	
			// open buffered reader to get data from stid
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			// Get the dimensions of the spreadsheet
            String[] dimension = in.readLine().split("\\s+");

			// Has to be a 2 dimensional spreadsheet
            if (dimension.length != 2) {
                System.out.println( "The first line of input should have only 2 itegers");
                return;
            }

			// Parse the dimensions, throws error of invalid dimension
            this.width = Integer.parseInt(dimension[0]);
            this.height = Integer.parseInt(dimension[1]);

			// WE are dealing only with 26 rows, throw error otherwise
            if (this.height > 26) {
                System.out.println( "The height cannot be more than 26");
                return;
            }

			// compute total number of elements in spreadsheet
            int total = this.width*this.height;

            // create a storage of size total
            this.spreadSheet = new String[total];

            // create the result spreadsheet
            this.spreadSheetValue = new Float[total];

            // read all the input lines and store them in spreadsheet
            for (int i=0;i<total; i++) {
                this.spreadSheet[i] = in.readLine().trim().toUpperCase();
            }

        } catch(IOException e) {
			System.out.println("Problem reading input");
            System.out.println(e);
        } catch(NumberFormatException e) {
            System.out.println("Width, height should be a number");
            System.out.println(e);
 		} catch (Exception e) {
				System.out.println(e);
		}
 
    }

	/** Function evaluate will go through the spreadsheet evaluate 
	 *  each entry and print the output to STDOUT
	 */
	public void evaluate() {
		
		// Maintain a hash set of seen references to detect cycles
		HashSet<String> hash = new HashSet<String>();
		try {
			for (int i=0; i<this.spreadSheet.length;i++) {
				// clear the hash at the beginning of each call
				hash.clear();
				
				// Evaluate the RPN for this row and store in the corresponding location
				this.evaluateRPN(i,hash); 
								
				// Print the computed value for this row in specified format
				System.out.println(String.format("%.5f",this.spreadSheetValue[i]));
			}
		} catch(InvalidRPNException e) {
		            System.out.println(e);
		}
	}
	

	/** the main function that evaluates a RPN and stores it in the appropriate location in 
      * in the spreadSheetValues. We can alternatively just let this return the solution,
      * but in that case, any future expressions would be recomputed each time instead of storing
      * the result. A classic tradoff for space vs time.
	  * @param loc the location in spreadsheet to be computed
	  * @param hash A hash set to keep track of circular references
	  * @throws InvalidRPNException if the Reverse polish notation is invalid
	*/
    protected void evaluateRPN(int loc, HashSet<String> hash) throws InvalidRPNException{
	
		// Get the current value to be evaluated
     	String value = this.spreadSheet[loc];
		
		// if null return invalid
        if (value == "") {
            throw new InvalidRPNException(value);
        }
   
		// Split the RPN by space to get the tokens
        String[] items = value.split("\\s+");

		// Maintain a stack to evaluate the RPN
		LinkedList<Float> stack = new LinkedList<Float>();
		
		// Loop through the tokens
		for (String item: items) {

			// If the token is a cell reference, evaluate that and add to stack
			if (item.matches("[A-Z][0-9]+")) {
				
				// Check if we have seen this reference already in our evaluation path,
				// if so, its a cyclic reference
				if (hash.contains(item)) {
					throw new InvalidRPNException(value,"Circular reference:");
				} else {
					hash.add(item);
				}
				
				// Convert the cell reference to a array location
				int row = item.charAt(0)-64;
				int col = Integer.parseInt(item.substring(1));
				
				// If the reference points outside the excel, throw error
				if (row > this.height || col > this.width) {
					throw new InvalidRPNException(value,"Reference points outside the excel:");
					
				}
				int location = ((row-1)*this.width) + col -1;
				
				// Recursively compute the RPN at the new location and store it there
				this.evaluateRPN(location,hash);
				
				// Since this reference was computed, we will remove it from hash as it will
				// not be a cyclic reference any more
				hash.remove(item);
				
				// Push the computed value into the stack
				stack.push(this.spreadSheetValue[location]);
			}
			// if it is a binary operator, perform the evaluation
			else if (item.equals("+") || item.equals("-") ||
					   item.equals("*") || item.equals("/")) {
				// check if there are 2 elements to operate on, 
				// else its an invalid expression
				if (stack.size() < 2) {
					throw new InvalidRPNException(value);
				}
				
				// compute the value of this operation and add it to stack
				stack.push(this.compute(item, stack.pop(), stack.pop()));
			}
			// else if its a unary operator, perform the evaluation
			else if(item.equals("++") || item.equals("--")) {
				// check if there is 1 element to operate on, 
				// else its an invalid expression
				if (stack.size() < 1) {
					throw new InvalidRPNException(value);
				}
				
				// compute the value of this operation and add it to stack
				stack.push(this.compute(item, stack.pop()));
			}
			// its a number, just push into stack
			else if (item.matches("[+-]??[0-9]*?[.]??[0-9]+?")) {
				stack.push(Float.parseFloat(item));
			}
			// anything else is an invalid expression
			else {
					throw new InvalidRPNException(value);
			}
			
		}
		
		
		// after computation, only one valus shd exist and that should be the solution
		if (stack.size() !=1) {
			throw new InvalidRPNException(value);
		}
	    
		// Add that to the spreadsheet to be stored for future use
		this.spreadSheetValue[loc] = stack.pop();
		return;
		
    }

	/** A function to compute the operations in the RPN expression
	  * @param operator The name of operator, can be +,-,*,/
	  * @param operand1 The RHS operand
	  * @param operand2 THE LHS operand
	  * @return the computed value
	*/
	protected Float compute (String operator, Float operand1, Float operand2) {
		if (operator.equals("+")) {
			return operand1+operand2;
		} 
		else if (operator.equals("-")) {
			return operand2-operand1;
		}
		else if (operator.equals("*")) {
			return operand1*operand2;
		}
		// We do not expect any other operator since we are 
		// already checkeing in evaluateRPN
		else {
			return operand2/operand1;
		} 
	}
	
	/** Overloaded to compute unary operations in the RPN expression
	  * @param operator The name of operator, can be ++ or --
	  * @param operand1 The RHS operand
	  * @return the computed value
	*/
	protected Float compute (String operator, Float operand1) {
		if (operator.equals("++")) {
			return operand1+1;
		} 
		// We do not expect any other operator since we are 
		// already checkeing in evaluateRPN
		else {
			return operand1-1;
		}
	}
	
}

/**
 * Exception class to handle invalid RPN expressions
 */
class InvalidRPNException extends Exception {
 
    private String exp;
	private String msg;
 
    public InvalidRPNException(String exp){
        this.exp = exp;
		this.msg = "Invalid Reverse Polish Notation expression:";
    }

	public InvalidRPNException(String exp, String msg){
        this.exp = exp;
		this.msg = msg;
    }
 
    public String toString(){
        return msg + " " +exp ;
    }
}
