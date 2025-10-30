import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 세로
        int M = sc.nextInt(); // 가로
        char[][] board = new char[N][M];

    
        for (int i = 0; i < N; i++) {
            String line = sc.next(); 
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                
                int countW = 0; 
                int countB = 0; 

                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        char current = board[k][l];

                        if ((k + l) % 2 == 0) {
                            if (current != 'W') countW++;
                            if (current != 'B') countB++;
                        } else {
                            if (current != 'B') countW++;
                            if (current != 'W') countB++;
                        }
                    }
                }

                min = Math.min(min, Math.min(countW, countB));
            }
        }

        System.out.println(min);
    }
}