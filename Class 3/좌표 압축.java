import java.util.Scanner;
import java.util.PriorityQueue;

public class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int N = sc.nextInt();
        
        int[] answer = new int[N];
        
        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            
            pq.add(new int[]{x,i});
        }
        
        int min = Integer.MIN_VALUE;
        int min_num = -1;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int num = cur[0];
            
            if(num > min){
                min = num;
                answer[cur[1]] = ++min_num;
            }else{
                answer[cur[1]] = min_num;
            }
        }
        for(int i = 0; i < N; i++){
            System.out.println(answer[i]);
        }
        
	}
}