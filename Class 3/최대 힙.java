import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a,b) -> Integer.parseInt(b) - Integer.parseInt(a));

        int N = sc.nextInt();

        while (N-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                if (!maxHeap.isEmpty()) {
                    System.out.println(maxHeap.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                maxHeap.add(Integer.toString(x));
            }
        }
    }
}