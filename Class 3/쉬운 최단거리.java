import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 세로
        int m = sc.nextInt(); // 가로
        
        int[][] map = new int[n][m];   // 지도
        int[][] dist = new int[n][m];  // 거리를 담을 배열
        int[][] visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        // 맵 입력 받기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
                // 목표 좌표 큐에 추가
                if(map[i][j] == 2){
                    queue.add(new int[]{j,i}); // (x,y) 저장
                    visited[i][j] = 1; 
                }
            }
        }
        
        int [] dx = new int[]{1,-1,0,0}; // 좌우 -> j
        int [] dy = new int[]{0,0,1,-1}; // 상하 -> i
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 체크
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
				// 0이면서 방문 했으면 패스
                if(map[ny][nx] == 0 || visited[ny][nx] == 1) continue;
                
                visited[ny][nx] = 1;
                dist[ny][nx] = dist[y][x] + 1;
                queue.add(new int[]{nx,ny});
            } 
        }
        
        // 출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
				// 방문 하지 못했는데 1이면 0으로 둘러쌓인 곳임 즉 -1 출력
                if(visited[i][j] == 0 && map[i][j] == 1){
                    System.out.print(-1 + " ");
                }
                else{
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
}