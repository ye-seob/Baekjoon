import java.util.Scanner;

public class Main{
    static int N;
    static int[][] map;
    static int blue_count = 0;
    static int white_count = 0;

public static void devide(int row, int col, int size) {
    
    if (size == 1) {
    if(map[row][col] == 0) white_count++;
    else blue_count++;
    return;
}

    
    int sum = 0;
    for (int i = row; i < row + size; i++) {
        for (int j = col; j < col + size; j++) {
            sum += map[i][j];
        }
    }

    
    if (sum == 0){
        white_count++;
        return;
    } 
    if (sum == size * size){
        blue_count++;
        return;
    } 
    
   
    
    int newSize = size / 2;

   
    devide(row, col, newSize);               // 좌상
    devide(row, col + newSize, newSize);     // 우상
    devide(row + newSize, col, newSize);     // 좌하
    devide(row + newSize, col + newSize, newSize); // 우하

    
    
}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        map = new int[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        

        devide(0,0,N);
        
        System.out.println(white_count);
        System.out.println(blue_count);
        
        
        
	}
}