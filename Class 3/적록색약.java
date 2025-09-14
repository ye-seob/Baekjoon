import java.util.Scanner;
public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 일반인 기준
        visited = new boolean[N][N];
        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    normalCount++;
                }
            }
        }

        // 적록색약 기준 → R을 G로 통일
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }

        visited = new boolean[N][N];
        int colorBlindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);
    }

    static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] == color) {
                    dfs(nx, ny, color);
                }
            }
        }
    }

}