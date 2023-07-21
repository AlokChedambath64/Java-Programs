public class friendspairing {

    public static int totalways(int n){
        if(n == 1 || n == 2){
            return n;
        }
        //single
        int fnm1 = totalways(n-1);
        //paired
        int fnm2 = totalways(n-2);
        int pairs = (n-1) * fnm2;

        return fnm1 + pairs;
    }

    public static void main(String args[]){
        System.out.println(totalways(3));
    }
}
