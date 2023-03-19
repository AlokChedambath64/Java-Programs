public class bintodec {
    public static int binarytodec(int a){
        int dec = 0;
        int lastdigit = 0;
        int pow = 0;
        while(a > 0){
            lastdigit = a % 10;
            dec = dec + lastdigit*(int)(Math.pow(2, pow));
            a = a/10;
            pow++;
        }
        return dec;
    }

    public static void main(String args[]){
        System.out.println(binarytodec(101));
    }
}
