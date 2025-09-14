import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        
        int M = sc.nextInt(); // ㄱㅏㄹㅗ  j x 
        int N = sc.nextInt(); // ㅅㅔㄹㅗ  i y
        
        int[][] box = new int[N][M]; // (y,x)
        int[][] visited = new int[N][M];
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1){
                    queue.add(new int[]{i,j});
                    visited[i][j] = 1;
                }
            } 
        }
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[1];
            int y = current[0];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(box[ny][nx] == -1 || visited[ny][nx] != 0) continue;
                
                box[ny][nx] = 1; // ㅇㅣㄱㅇㅡㄴ ㅌㅗㅁㅏㅌㅗㄹㅗ ㅂㅕㄴㄱㅕㅇ
                visited[ny][nx] = visited[y][x] + 1; // ㅇㅣㄱㅇㅡㄴ ㄴㅏㄹㅉㅏ ㄱㅐㅇㅅㅣㄴ
                queue.add(new int[]{ny,nx});
            }
        }
        int day = 1;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 0 && visited[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day,visited[i][j]);
            } 
        }
        System.out.println(day -1 );
	}
}