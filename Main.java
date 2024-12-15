import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] col1 = new int[n];
            int[] col2 = new int[n];

            for (int i = 0; i < n; i++) col1[i] = sc.nextInt();
            for (int i = 0; i < n; i++) col2[i] = sc.nextInt();

            int i = 0, j = 0;
            while (j < n) {
                if (col1[j] > col2[j]) {
                    swap(col1, col2, i, j);
                    i++;
                }
                j++;
            }
            int sum=0;
            int k;
            for(k=0;k<n;k++)
            {
                if(col1[k]>=col2[k])
                    sum+=col1[k];
                else
                {
                    sum+=col1[k];

                    break;
                }
            }
            for(int l=k;l<n;l++)
            {
                sum+=col2[l];
            }
            System.out.println(sum);
        }
    }

    // Swap function to swap elements in both arrays
    public static void swap(int[] col1, int[] col2, int i, int j) {
        int temp = col1[i];
        col1[i] = col1[j];
        col1[j] = temp;

        temp = col2[i];
        col2[i] = col2[j];
        col2[j] = temp;
    }
}
