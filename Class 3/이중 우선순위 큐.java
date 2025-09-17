import java.util.Scanner;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        

        while(T-- > 0){
            TreeMap<Integer,Integer> map = new TreeMap<>();
            int k = sc.nextInt();
            while(k-- > 0){
                char cmd = sc.next().charAt(0);
                int n = sc.nextInt();
                if(cmd == 'I'){
                    map.put(n, map.getOrDefault(n,0)+1);
                }
                else{ 
                    int x = 0;
                    if(map.isEmpty())continue;
                    if(n == 1) x = map.lastKey(); // 최대값 
                    if(n == -1)x = map.firstKey(); 

                    int x_num = map.get(x);
                    
                    if(x_num == 1){
                        map.remove(x);
                        
                    }else{
                         map.put(x, x_num-1);
                    }
                }
            }
            
            if(map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(map.lastKey() + " " + map.firstKey());
        }
    }
}