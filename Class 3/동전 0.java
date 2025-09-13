import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();
        int num = 0;

        int[] price = new int[N];

        for (int i = 0; i < N; i++) {
            price[i] = sc.nextInt();
        }

        while (k > 0) {
            if (k - price[N - 1] < 0) {
                N--;
            } else {
                num++;
                k -= price[N - 1];
            }
        }

        System.out.println(num);
    }
}