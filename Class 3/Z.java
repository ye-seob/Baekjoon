import java.util.Scanner;

public class Main{
    static int count = 0;
    static int N;
    static int r,c;
    
    public static void recursion(int row,int col ,int size){
        
        int new_size = size / 2;
        
        if(size == 1){
            return;
        }
        if(r < row +  new_size && c < col +  new_size){
            recursion(row,col,new_size);
        }
        if(r < row +  new_size && c >= col +  new_size){
            count += new_size*new_size * 1;
            recursion(row,col + new_size,new_size);            
        }
        if(r >= row +  new_size && c < col +  new_size){    
            count += new_size*new_size * 2;
            recursion(row+new_size,col,new_size);
        }
        if(r >= row +  new_size && c >= col +  new_size){
            count += new_size*new_size * 3;
            recursion(row+new_size,col+new_size,new_size);
        }
        
        
        
        
    }
    
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
       
        recursion(0,0,(int)Math.pow(2,N));
        
        System.out.println(count);
	}
}