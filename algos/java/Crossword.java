//Given a dictionary of words and an array of letters, how do you find all the words in that. Kinda like crossword. Words can go in all direction



//Better to use a trie so we can cut off earlier if needed.


void findWords(Trie T char[][] letters) {

int height = letter.length, width = letter[0].length;



for int(i=0; i < height ; i++) {


	for (int j=0; j<width ; j++) {
		int r = j+1;
		StringBuffer str = new StringBuffer(letter[i][j]);
		while(r <= width -1) {
			if(hasPrefix(str=str+letter[i][r])) {
				if (exactMatch(str)) {
					System.out.println(i,j and h,r);
				}
				r++
			}
		}
	}
}


}