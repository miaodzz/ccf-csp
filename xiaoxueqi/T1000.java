package xiaoxueqi;
import java.util.*;
public class T1000 {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int num[][]=new int[n+1][n+1];
		for(int i=1;i<n+1;i++){//i=1,2,3,,,,n 
			for(int j=1;j<i+1;j++){
				//j=1,2,...i
				num[i][j]=sc.nextInt();
			}
		}
		String record[]=new String[n+1];
		for(int i=1;i<n+1;i++){
			record[i]=String.valueOf(num[n][i]);
		}
		
		for(int i=n-1;i>0;i--){
			for(int j=1;j<i+1;j++){
				if(num[i+1][j]>num[i+1][j+1]){

					record[j]=num[i][j]+" "+record[j];
					num[i][j]=num[i+1][j]+num[i][j];
				}else{

					record[j]=num[i][j]+" "+record[j+1];
					num[i][j]=num[i+1][j+1]+num[i][j];
				}
				
			}
		}
		System.out.println(num[1][1]);
		System.out.println(record[1]);
	}
}
