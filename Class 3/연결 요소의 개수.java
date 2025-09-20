import java.util.Scanner;

public class Main{
    static int[] visited;
    static int[][] graph;
    static int count = 0;
    static int N;
    
    public static void DFS(int u){
        visited[u] = 1;
        for(int i = 1; i <= N; i++){
            if(graph[u][i] == 1 && visited[i] == 0){
                DFS(i);
            }
        }
    }
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        int M = sc.nextInt();
        
        graph = new int[N + 1][N + 1];
        visited = new int[N + 1];
        
        while(M-- > 0){
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {   // 아직 방문 안 한 정점 
                DFS(i);             // 그 정점부터 DFS로 탐색
                count++;            // 연결 요소 
            }
        }
        System.out.println(count);
	}
}