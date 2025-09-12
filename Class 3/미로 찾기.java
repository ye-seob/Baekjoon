import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int[]> queue = new LinkedList<>();

        int N = sc.nextInt(); // 세로(행)
        int M = sc.nextInt(); // 가로(열)

        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];
        int[][] dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String num = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = num.charAt(j) - '0';
            }
        }

        int[] dy = {1, -1, 0, 0}; // 상하
        int[] dx = {0, 0, 1, -1}; // 좌우

        queue.add(new int[]{0, 0}); 
        visited[0][0] = 1;
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx] == 1 || map[ny][nx] == 0) continue;

                visited[ny][nx] = 1;
                dist[ny][nx] = dist[y][x] + 1;
                queue.add(new int[]{ny, nx});
            }
        }

        System.out.println(dist[N - 1][M - 1]);
    }
}