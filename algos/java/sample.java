class Sample {

    public static void main(String[] args) {
        String abc = "  123  ";
        System.out.println(abc.trim().toUpperCase());
        Float d = Float.parseFloat("20.0");
        System.out.println(String.format("%.5f",d));

        char c = 'Z';
        int num = c-64;
        String reference = "A23";
        int row = reference.charAt(0)-64;
        int col = Integer.parseInt(reference.substring(1));
        System.out.println("row: "+ row+" col "+col);
        return;

    }


}
