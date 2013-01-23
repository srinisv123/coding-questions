// Given a string, find if any of its anagram is a palindrome.
import java.util.HashMap;
class AnagramOfStringPalindrome {

    protected boolean checkPalindrome(String word) {
		HashMap map = new HashMap();
		char[] characters = word.toCharArray();
		int length = characters.length;
		for (int i=0; i<length ; i++) {
			if (map.containsKey(characters[i])){
				int k = ((Integer)map.get(characters[i])).intValue();
				map.put(characters[i],new Integer(++k));
			} else {
				map.put(characters[i],new Integer(1));
			}
		}
		boolean oneAllowedOddNum = false;
		for(int i=0; i<length ; i++) {
			int k = ((Integer)map.get(characters[i])).intValue();
			if (k%2!=0) {
				if(!oneAllowedOddNum) {
					oneAllowedOddNum = true;
				} else {
					return false;
				}
			}
			
		}
		return true;
		
	}

    public static void main(String[] args) {

        AnagramOfStringPalindrome anagram = new AnagramOfStringPalindrome();
        String word = args[0];
        if(anagram.checkPalindrome(word)) {
			System.out.println("Can have palindrome anagrams");
		} else {
			System.out.println("Can not have palindrome anagrams");
		}
    }
    
}
