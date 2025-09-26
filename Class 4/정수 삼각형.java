import java.util.Scanner;

public class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int [][] triangle = new int[N][N];
        
        int[][] dp = new int[N][N];
        
        // ㅅㅏㅁㄱㅏㄱㅎㅕㅇ ㅇㅣㅂㄹㅕㄱ ㅂㅏㄷㄱㅣ
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i + 1; j++){
                triangle[i][j] = sc.nextInt();
            }
        }
        
        dp[0][0] = triangle[0][0];
        if(N == 1){
            System.out.println(dp[0][0]);   
            return;
        }
      
        int max = dp[0][0];
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i + 1; j++){
                if(j == 0){
                    //ㅁㅐㄴ ㅇㅗㅣㄴㅉㅗㄱ 
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
                else if(j == i){
                    //ㅁㅐㄴ ㅇㅗㄹㅡㄴㅉㅗㄱ 
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1],dp[i - 1][j]) + triangle[i][j];
                }
                if(max < dp[i][j]) max = dp[i][j];
            }
        }
        System.out.println(max);
 
	}
}