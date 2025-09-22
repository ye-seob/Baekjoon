import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    static int N;
    static int M;
    static ArrayList<Integer> list;
    static boolean[] used;
    
    public static void backtrack(int start){
        if(list.size() == M){
            for(int i = 0; i < M; i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println("");
            return;
        }
        
        for(int i = start; i <= N; i++){
            if (used[i]) continue;        
            used[i] = true;             
            list.add(i);

            backtrack(i);                

            used[i] = false;
            list.remove(list.size() - 1);    
        }
        
        
    }
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        used = new boolean[N + 1];
        
        backtrack(1);
	}
}