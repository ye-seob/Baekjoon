import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int bitset = 0; // 비트마스킹으로 집합 표현
        int M = Integer.parseInt(br.readLine());
        
        while (M-- > 0) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            int num = 0;
            
            if (!cmd.equals("all") && !cmd.equals("empty")) {
                num = Integer.parseInt(input[1]);
            }
            
            switch (cmd) {
                case "add":
                    bitset |= (1 << (num - 1));
                    break;
                case "remove":
                    bitset &= ~(1 << (num - 1));
                    break;
                case "check":
                    sb.append((bitset & (1 << (num - 1))) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    bitset ^= (1 << (num - 1));
                    break;
                case "all":
                    bitset = (1 << 20) - 1;
                    break;
                case "empty":
                    bitset = 0;
                    break;
            }
        }
        
        System.out.print(sb);
    }
}