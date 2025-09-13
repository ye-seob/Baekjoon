import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        char[][] map = new char[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[N][M];
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        // 지도 입력 받기
        for(int i = 0; i < N; i++){
            String line = sc.next();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'I') {
                    queue.add(new int[]{j,i}); // (x, y) 좌표
                    visited[i][j] = 1; // 시작 위치 방문 처리
                }
            }
        }
        
        // O : 빈 공간
        // X : 벽
        // I : 본인 위치
        // P : 다른 사람
        int count = 0;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(map[ny][nx] == 'X' || visited[ny][nx] == 1) continue;
                
                if(map[ny][nx] == 'P') count++;
                
                visited[ny][nx] = 1;
                queue.add(new int[]{nx,ny});
            }
        }
        
        if(count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }
}