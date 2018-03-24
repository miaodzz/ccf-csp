package xiaoxueqi;
import java.util.*;
public class T1001 {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();//行数
		int m=sc.nextInt();//列数
		int num[][]=new int[n][m];
		for(int i=0;i<n;i++){//i=1,2,3,,,,n 
			for(int j=0;j<m;j++){
				num[i][j]=sc.nextInt();
			}
		}
		
		for(int i=m-1;i>-1;i--){
			for( int j=0;j<n;j++){
				System.out.print(num[j][i]+" ");
			}
			System.out.println("");
		}
		
		
	}
}
