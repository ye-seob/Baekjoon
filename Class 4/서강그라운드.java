import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 정점
        int m = sc.nextInt(); 
        int E = sc.nextInt(); // 간선

        List<List<int[]>> graph = new ArrayList<>();

        int[] item = new int[V+1]; // 1-base index

        for(int i = 1; i <= V; i++){
            item[i] = sc.nextInt();
        }

        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            graph.get(a).add(new int[]{b,w});
            graph.get(b).add(new int[]{a,w});
        }

        int max = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] dist = new int[V+1][V+1];

        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                dist[i][j] = Integer.MAX_VALUE;
                if(i==j) dist[i][j] = 0;
            }
        }

        for(int i = 1; i <= V; i++){
            pq.add(new int[]{i,0});

            while(!pq.isEmpty()){
                int[] current = pq.poll();
                int vertex = current[0];
                int weight = current[1];

                if(weight > dist[i][vertex]) continue;

                for(int k=0; k < graph.get(vertex).size(); k++){
                    int dest = graph.get(vertex).get(k)[0];
                    int dest_w = graph.get(vertex).get(k)[1];

                    if(dest_w + weight < dist[i][dest]){
                        dist[i][dest] = dest_w+weight;
                        pq.add(new int[]{dest, dist[i][dest]});
                    }
                }
            }
        }

        for(int i = 1; i <= V; i++){
            int tmp = 0;
            for(int j = 1; j <= V; j++){
                if(dist[i][j] <= m)tmp += item[j];        
            }
            if(max < tmp) max = tmp;
        }

        System.out.println(max);
    }
}