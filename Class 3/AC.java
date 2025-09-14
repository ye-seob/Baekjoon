import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        while (T-- > 0) {
            String cmd = sc.next(); // 명령어
            int length = sc.nextInt(); // 배열 길이
            String line = sc.next(); //  [1,2,3,4]

            Deque<Integer> deque = new LinkedList<>();

           
                String line2 = line.substring(1, line.length() - 1); // 대괄호 제거
                String[] line3 = line2.split(",");
                for (int i = 0; i < length; i++) {
                    deque.addLast(Integer.parseInt(line3[i]));
                }
            

            boolean reversed = false;
            boolean error = false;

            for (int i = 0; i < cmd.length(); i++) {
                char c = cmd.charAt(i);
               
                if (c == 'R') {
                    reversed = !reversed;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (reversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (error) {
                sb.append("error\n");
                continue;
            }

            sb.append("[");
            if (!deque.isEmpty()) {
                if (reversed) {
                    while (deque.size() > 1) {
                        sb.append(deque.pollLast()).append(",");
                    }
                    sb.append(deque.pollLast());
                } else {
                    while (deque.size() > 1) {
                        sb.append(deque.pollFirst()).append(",");
                    }
                    sb.append(deque.pollFirst());
                }
            }
            sb.append("]\n");
        }

        System.out.print(sb);
    }
}