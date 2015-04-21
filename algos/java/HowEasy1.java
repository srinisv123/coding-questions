public class HowEasy1 {

public static void main (String[] args) {
    Integer len = pointVal("abcd ..");
    System.out.println("Hello lenth is " + len);
}
public static Integer pointVal (String problem) {
    int wordLength = 0, numWords = 0;
    int len = problem.length();
    int cur = 0;
    while(true) {
        int curWordLen = 0;
        // skip spaces
        while (cur < len && problem.charAt(cur) == ' ') {
            cur++;
        }

        // As long as we are in this loop, We are seeing a legal word. Keep going until you hit a space
        while (cur < len && ((problem.charAt(cur) >= 'a' && problem.charAt(cur) <= 'z') ||
                        (problem.charAt(cur) >= 'A' && problem.charAt(cur) <= 'Z'))) {
            cur++;
            curWordLen++;
        }
    
        // Did we just see a word?
        if ((   cur == len ||
            (cur < len && (problem.charAt(cur) == ' ')) || 
            (cur == len - 1 && (problem.charAt(cur) == '.')) ||
            (cur < len - 1 && (problem.charAt(cur) == '.' && problem.charAt(cur + 1) == ' '))) &&
            curWordLen > 0) {
            wordLength += curWordLen;
            numWords++; 
        }



        // If we hit a bad word in the previous loop, this one will get us till the end of the token
        while (cur < len && problem.charAt(cur) != ' ') {
            cur++;
        }


        if (cur == problem.length()) {
            break;
        }
    }
    System.out.println("wl is " + wordLength);
    System.out.println("no words " + numWords);
    int avgWordLength =  0;
    if (numWords != 0) 
        avgWordLength = wordLength/numWords;
    if (avgWordLength <= 3) {
        return Integer.valueOf(250);
    } else if (avgWordLength <= 5) {
                return Integer.valueOf(500);
    } else {
                return Integer.valueOf(1000);
    }
}
}
