class NumberClassValidSubstring {




    public static boolean validSubString(String data, int num) {
        
        if (num == 0) {
            return true;
        }
        if (data.length() == 0) {           
            return false;
        }

        int currentNum = Integer.parseInt(data.substring(0,1));

        if (currentNum > num) {
            validSubString(data.substring(currentNum-1))




    }



}
