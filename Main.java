
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();

        int cost = k*(w+1)*w/2;

        if (cost>n)
            System.out.println(cost-n);
        else
            System.out.println(0);
        

    }
}

