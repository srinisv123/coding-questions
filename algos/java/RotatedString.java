class RotatedString {

    public static void main(String[] arg) {

        if (isRotated(arg[0],arg[1])) {
            System.out.println("Rotated");
        }
        else {
            System.out.println("Not rotated");
        }
    }


    public static boolean isRotated(String str1, String str2) {

        

        String str3 = str2+str2;

        if (str1.length() == str2.length() && str1.length() != 0 && str3.matches("(?i).*"+str1+".*")) {
            return true;
        }

        return false;
        

    }


}
