import java.util.Scanner;

public class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // ㄴㅏㅁㅜ ㅅㅜ 
        long M = sc.nextLong(); // ㄱㅏㅈㅕㄱㅏㄹㅕㄱㅗ ㅎㅏㄴㅡㄴ ㄱㅣㄹㅇㅣ 
        
        long[] trees = new long[N];
        
        
        long max =  Long.MIN_VALUE;
        long min =  0;
        
        for(int i = 0; i < N; i++){
            trees[i] = sc.nextLong();
            if(max < trees[i]) max = trees[i];
        }
       
        long mid = (max + min) / 2;
        long answer = 0;
        while(max >= min){
            answer = 0;
            for(int i = 0; i < N; i++){
                if(trees[i] - mid > 0){
                    answer += trees[i] - mid;
                }
            }
            if(answer < M) max = mid - 1; 
            if(answer > M) min = mid + 1;
            if(answer == M){
                System.out.println(mid);
                return;
            }
            mid = (min + max) / 2;
        }
        System.out.println(max);
     
	}
}