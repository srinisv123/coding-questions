/* Check if a given string is a number
*
*/
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class isNumber {

    public static void main(String[] args) {

        if (isNumber(args[0])) {
            System.out.println("Is a number");
        } else { 
            System.out.println("not a number");
        }

    }

    public static boolean isNumber(String str) {

        Pattern pattern = Pattern.compile("[+-]??[0-9]*?[.]??[0-9]+?");
        Matcher m = pattern.matcher(str);

        if (m.matches()) {
            return true;
        }

        return false;
    }


}
