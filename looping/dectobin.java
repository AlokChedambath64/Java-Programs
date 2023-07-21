public class dectobin {
    public static int decimalconversion(int dec){
        int pow = 0;
        int rem = 0;
        int bin = 0;

        while(dec >= 1){
            rem = dec % 2;
            bin = bin + (rem)*(int)Math.pow(10,pow);
            dec = dec / 2;
            System.out.println(dec);
            pow++;
        }
        return bin;
    }

    public static void main(String args[]){
        System.out.println(decimalconversion(7));
    }
}
