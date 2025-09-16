import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<String> absHeap = new PriorityQueue<>((a,b) -> {
         if(Math.abs(Integer.parseInt(a)) == Math.abs(Integer.parseInt(b))){
            return Integer.parseInt(a) - Integer.parseInt(b);
         }
         else{
            return  Math.abs(Integer.parseInt(a)) - Math.abs(Integer.parseInt(b));
         }
      
        });

        int N = sc.nextInt();

        while (N-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                if (!absHeap.isEmpty()) {
                    System.out.println(absHeap.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                absHeap.add(Integer.toString(x));
            }
        }
    }
}