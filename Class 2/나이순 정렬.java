import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
		public static void main(String [] args) throws IOException{
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int N = Integer.parseInt(br.readLine());
            
            int[][] age = new int[N][2];
            String[] name = new String[N];
            
            StringTokenizer st;
           
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                age[i][0] = Integer.parseInt(st.nextToken());
                age[i][1] = i;
                name[i] = st.nextToken();
            }
            
            Arrays.sort(age,(o1,o2)->{
                return o1[0] - o2[0];
            });
            
            for(int i = 0; i < N; i++){
                System.out.println(age[i][0] + " " + name[age[i][1]]);
			}
            
                
             
        }
}