


class Boggle {






    public static void main(String[] args) {
        Boggle boggle = new Boggle();
    }
}




class Trie {
    public char letter;

    public String meaning;

    public Trie[] children;


    public Trie(char letter, String meaning,  ) {

        letter = letter;
        meaning = meaning;
    }

    public hasMeaning() {
        if (meaning!=null) {
            return true;
        }

        return false;
    }

    public hasChildren() {
        if (children !=null) {
            return true;
        }

         return false;
    }
}