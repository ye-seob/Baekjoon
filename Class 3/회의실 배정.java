import java.util.Scanner;
import java.util.Arrays;

public class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[][] times = new int[N][2];
        
        for(int i = 0; i < N; i++){
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
        }
        
        // ㄲㅡㅌㄴㅏㄴㅡㄴ ㄱㅣㅈㅜㄴㅇㅡㄹㅗ ㅇㅗㄹㅡㅁㅊㅏㅅㅜㄴ ㅈㅓㅇㄹㅕㄹ
        Arrays.sort(times,(o1,o2)->{
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
     
        int endTime = 0;
        int count = 0;
        
        for(int i = 0; i < N; i++){
            if(endTime <= times[i][0]){
                endTime = times[i][1];
                count++;
            }    
        }
        System.out.println(count); 
        
        
	}
}