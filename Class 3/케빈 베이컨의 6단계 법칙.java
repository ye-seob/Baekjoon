import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); 
        int M = sc.nextInt(); 
        int INF = Integer.MAX_VALUE; 
        int [][] graph = new int[N+1][N+1];
        
        for(int i = 1; i <= N; i++){
           for(int j = 1; j <= N; j++){
               if (i == j) graph[i][j] = 0;
               else graph[i][j] = INF;
               
           }
        }
        
        int a,b;
        
        for(int i = 0; i < M; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(graph[i][k] != INF && graph[k][j] != INF){
                        graph[i][j] = Math.min(graph[i][j],graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
        int min = INF;
        int sum = 0;
        int answer = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                sum += graph[i][j];
            }
            if(sum < min){
                min = sum;
                answer = i;
            } 
            sum = 0;
        }
        System.out.println(answer);
    }
}