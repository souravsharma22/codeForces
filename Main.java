
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int asum = 0;
        int bsum = 0;
        int[] a = new int[n];
        Set<Integer> sa = new HashSet<>();
        Set<Integer> sb = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            asum += a[i];
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            bsum += b[i];
        }
        for(int i=0;i<n;i++)
            sa.add(asum-a[i]);
        for(int i=0;i<m;i++)
            sb.add(bsum-b[i]);
        while (q-- > 0) {
            int x = sc.nextInt();
            boolean flag =false;
            boolean sign =x>=0;
            x = Math.abs(x);
            for(int i=1;i*i<=x;i++)
            {
                if(x%i==0)
                {
                    int y=i,z=x/i;
                    if(sign)
                    {
                        if(have(y, z, sa, sb) || have(-y, -z, sa, sb))
                        {
                            flag=true;
                            break;
                        }
                    }
                    else
                    {
                        if(have(-y, z, sa, sb) || have(y, -z, sa, sb))
                        {
                            flag=true;
                            break;
                        }
                    }
                    int temp;
                    temp=y;
                    y=z;
                    z=temp;
                    if(sign)
                    {
                        if(have(y, z, sa, sb) || have(-y, -z, sa, sb))
                        {
                            flag=true;
                            break;
                        }
                    }
                    else
                    {
                        if(have(-y, z, sa, sb) || have(y, -z, sa, sb))
                        {
                            flag=true;
                            break;
                        }
                    }
                    
                }
                    
            }
            System.out.println((flag?"Yes":"NO"));
        }

    }
    public static boolean have(int x,int y,Set<Integer> sa,Set<Integer> sb)
    {
        return (sa.contains(x) && sb.contains(y));
    }
}
