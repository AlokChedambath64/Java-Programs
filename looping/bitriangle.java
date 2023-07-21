public class bitriangle {
    public static void triangle(int n){
        int counter = 0;
        for (int i = 1; i <= n; i++){
            for (int j =1; j <= i; j++){
                if(counter % 2 == 0){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
                counter++;
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        triangle(6);
    }
}
