import java.io.*;
import java.util.*;

class MorseCodeCorrection {

	HashMap<String,String> alphas;
	HashSet<String> dict;
	
	public MorseCodeCorrection() {
		 	alphas = new HashMap<String, String>();
			dict = new HashSet<String>();
	}
		
		
    public static void main(String[] args) {

        //Get the input file name from command line
        String inputFile = args[0];
		MorseCodeCorrection correction = new MorseCodeCorrection();

        try {
    
            //Open a buffered reader with File Reader
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
				
				
			String str;
			String type="alpha";
			
			//read each line and separate the input into alpha, dict and code
			while((str =br.readLine())!=null) {
            	
				
				if (type=="alpha") {
	
					if (str.equals("*")) {
						type="dict";
					} else {
						correction.addAlpha(str);
					}
					continue;
				}
				
				if (type=="dict") {
					if (str.equals("*")) {
						type="code";
					} else {
						correction.addDict(str);
					}
					continue;
				}
				
				if (type=="code" && !str.equals("*")) {
					correction.checkCode(str);
				}
				
			}
			br.close();

        } catch(IOException e) {
            System.out.println("Error: "+e.getMessage());
        }

        
    }


	public void addAlpha(String inputLine) {
		String[] keyVal= inputLine.split("\\s+");
		
		alphas.put(keyVal[1],keyVal[0]);

	}
	
	public void addDict(String word) {
		dict.add(word);
	}

	
	public void checkCode(String codeLine) {
		ArrayList<String> possibleWords = new ArrayList<String>();
		String[] codes= codeLine.split("\\s+");
		for(String code : codes) {
			possibleWords = this.codeConvert(code);
		}
	}
	
	public ArrayList<String> codeConvert(String str, int start) {
		
		for (int i=1; i<=str.length(); i++) {
			String firstChar = str.substring(0,i);
			if (!alphas.containsKey(firstChar)) {
				continue;
			} else {
				
			}
			
			
			
	}


}
