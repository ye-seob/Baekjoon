import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<List<int[]>> graph = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        
        int V = sc.nextInt(); // 정점 개수
        int E = sc.nextInt(); // 간선 개수
        int K = sc.nextInt(); // 시작 정점
        
        int[] dist = new  int[V + 1]; // 시작 정점으로부터의 거리
        
         // 시작 정점은 0으로 나머지는 INF로 초기화
        for(int i = 1; i <= V; i++){
            dist[i] = Integer.MAX_VALUE;         
        }
        dist[K] = 0; 
        
        pq.add(new int[]{0,K}); // 우선순위 큐에 [거리,정점] 구조로 시작 정점  추가
        
        for(int i = 0; i <= V; i++){ // 인접리스트 초기화
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < E; i++){ // 인접리스트 간선 추가 
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt(); 
            
            graph.get(u).add(new int[]{v,w}); // u -> v 가중치 w
        }
        
        while(!pq.isEmpty()){
            int[] current = pq.poll(); // current[0] 거리 current[1] -> 정점
            int distance = current[0]; // w
            int vertex = current[1]; // u
            
            if(distance > dist[vertex]) continue; // 거리가 크다면 굳이 볼 필요 x
            
            for(int i = 0; i < graph.get(vertex).size(); i++){
                int neighbor = graph.get(vertex).get(i)[0]; // 이웃 정점 번호
                int weight = graph.get(vertex).get(i)[1];   // 간선 가중치

                if(distance + weight < dist[neighbor]){
                    dist[neighbor] = distance + weight;
                    pq.add(new int[]{dist[neighbor], neighbor});
                }

            }
            
        }
        
        for (int i = 1; i < V + 1; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
        
    }
}