class ReverseWords {


    public static void main(String[] args) {


        String word = args[0];

        String reversedSentence = reverseWords(word);

        int len = word.length();

        String currentWord = "";
        while (int i=0;i<len;i++) {
           if ( 

        }

        

    }

    public static String reverseWords(String words) {

        char[] charWords = words.toCharArray();

        int start =0;
        int end = charWords.length;

        while (start < end) {
            charWords[start++] = charWords[end--];
        } 

        String returnVal = new String(charWords);
        return returnVal;
    }


}
