public class Main {
    public static void main(String[] args){
        int rev = 0;
        int num = 573849;
        int ldig = 0;

        for(int i=0;i<6;i++){
            ldig = num % 10;
            rev = (rev * 10)+ldig;
            num = num / 10;
        }
        System.out.println(rev);
    }
}
