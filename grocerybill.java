import java.util.*;
public class gstbill {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float item1 = sc.nextFloat();
        float item2 = sc.nextFloat();
        float item3 = sc.nextFloat();

        float total = item1 + item2 + item3;
        System.out.println("Total:");
        System.out.println(total);
        System.out.println("With GST: ");
        System.out.println(total+(total*0.18));

    }
}
