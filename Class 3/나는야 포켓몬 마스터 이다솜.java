import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

		// 양방향 맵 매핑
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            map1.put(i + 1, name);
            map2.put(name, i + 1);
        }
		
		// num으로 형 변환이 되면 map1에서 String을 꺼냄
		// try-catch로 잡아서 안 되면 map2 에서 int를 꺼냄
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String token = st.nextToken();

            try {
                int num = Integer.parseInt(token);
                sb.append(map1.get(num));
            } catch (NumberFormatException e) {
                sb.append(map2.get(token));
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}