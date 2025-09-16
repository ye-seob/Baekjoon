import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> Integer.parseInt(a) - Integer.parseInt(b));

        int N = sc.nextInt();

        while (N-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                if (!minHeap.isEmpty()) {
                    System.out.println(minHeap.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                minHeap.add(Integer.toString(x));
            }
        }
    }
}