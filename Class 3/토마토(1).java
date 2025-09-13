import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
 
public class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 가로  j  x
        int N = sc.nextInt(); // 세로  i  y
        int H = sc.nextInt(); // 높이 k  z
        
        int[][][] map = new int[H][N][M];
        int[][][] visited = new int[H][N][M]; // 방문 배열
        Queue<int[]> queue = new LinkedList<>();
        
        
        // 토마토 위치 입력받고
        // 토마토가 있는 위치면 큐에 저장 후 방문 처리
        for(int k = 0; k < H; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    map[k][i][j] = sc.nextInt();
                    if(map[k][i][j] == 1){
                        queue.add(new int[]{k,i,j});// (h,y,x)
                        visited[k][i][j] = 1;
                    }
                }    
            }
        }
        
        int[] dx = {1,-1,0,0,0,0};
        int[] dy = {0,0,1,-1,0,0};
        int[] dz = {0,0,0,0,1,-1};
        
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            int x = current[2];
            int y = current[1];
            int z = current[0];
            
            for(int i = 0; i < 6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                // 범위 체크
                if(nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) continue;
                // 다른 토마토가 없거나 방문한 경우
                if(map[nz][ny][nx] == -1 || visited[nz][ny][nx] != 0) continue;
                
                // 익지 않은 토마토인 경우       
                if(map[nz][ny][nx] == 0){                   
                    map[nz][ny][nx] = 1;  // 익은 토마토로 바꿔줌
                    visited[nz][ny][nx] = visited[z][y][x] + 1; // 방문처리 
                    queue.add(new int[]{nz,ny,nx}); // 큐에 추가
                }
                
               
            }
        }
        
       int day = 0;
       for(int k = 0; k < H; k++){
           for(int i = 0; i < N; i++){
               for(int j = 0; j < M; j++){
                   if(map[k][i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, visited[k][i][j]);
               }
            }
        }
        System.out.println(day - 1);
	}
}