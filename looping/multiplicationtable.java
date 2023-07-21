import java.util.*;
public class multiplication {
    public static void main(String[] argv){
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("What number do you want the multiplication table of");
        num = sc.nextInt();
        for (int i = 0; i <= 10 ; i++){
                System.out.println(i+"*"+num+"="+i*num);
        }
    }
}
