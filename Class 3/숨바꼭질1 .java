import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        Queue<int[]> queue = new LinkedList<>();
        
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] visited = new int[100001];
        
        queue.add(new int[]{N,0});
        
        int time = 0;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            if(current[0] == K) {
                time = current[1];
                break;
            }
            if(visited[current[0]] != 1){
                visited[current[0]] = 1;
                if(current[0] - 1 >= 0) queue.add(new int[]{current[0] - 1,current[1]+1});
                if(current[0] + 1 <= 100000) queue.add(new int[]{current[0] + 1,current[1]+1});
                if(current[0] * 2 <= 100000) queue.add(new int[]{current[0] * 2,current[1]+1});
            }
            
        }
        System.out.println(time);
	}
}