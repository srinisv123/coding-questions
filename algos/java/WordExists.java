class WordExists {



    public static void main(String[] args) {

        char chars[][] = new char[][] 
        {{'a', 'b', 'c','d'},
         {'e', 'f','g','h'},
         {'i','j','k','l'},
         {'m','n','o','p'}};

        boolean hash[][] = new boolean[][]
        {{false,false,false,false},
        {false,false,false,false},
        {false,false,false,false},
        {false,false,false,false}};

        char word[] = args[0].toCharArray();

        if (wordExists(chars,0,0,word,0,hash)) {

            System.out.println("Exists");
        } else {
            System.out.println("Does not exist");
        }

        return;


    }





    public static boolean wordExists(char[][] chars, int row, int col,
                                  char[] word, int position,
                                  boolean[][] hash) {


        if (row >= chars.length || col >= chars[0].length ||
            row < 0  || col <0 ) {
            return false;
        }

        if (position >= word.length) {
            return true;
        }


        if (hash[row][col]) {
            return false;
        }


        if (chars[row][col] == word[position]) {

            hash[row][col] = true;
    
            if (wordExists(chars,row,col+1,word,position+1,hash)) {
                return true;
            }

            if (wordExists(chars,row-1,col,word,position+1,hash)) {
                return true;
            }
    
            if (wordExists(chars,row,col-1,word,position+1,hash)) {
                return true;
            }

            if (wordExists(chars,row+1,col,word,position+1,hash)) {
                return true;
            }
        } else {
            hash[row][col] =false;

            if (col == chars[0].length-1) {
                if (row == chars.length) 
                    return false;
                row++;
                col=0;
            } else {
                col++;
            }


            return wordExists(chars,row,col,word,0,hash);
        }

        return false;
    }






}
