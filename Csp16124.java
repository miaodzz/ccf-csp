import java.util.*;
public class Csp16124 {
	static int W[];
	static int w[];
	static int Cost[][];
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		W=new int[n+1];
		w=new int[n+1];
		Cost=new int[n+1][n+1];
		for(int i=1;i<n+1;i++){
			Cost[i][i]=0;
			w[i]=sc.nextInt();
			W[i]=W[i-1]+w[i];
			Cost[i-1][i]=w[i]+w[i-1];
		}
		
		for(int cha=2;cha<n;cha++){
			for(int i=1;i+cha<=n;i++){
				int min=Integer.MAX_VALUE;
				for(int x=i;x<=i+cha-1;x++){
					if(min>Cost[i][x]+Cost[x+1][i+cha]) min=Cost[i][x]+Cost[x+1][i+cha];
				}
				Cost[i][i+cha]=min+W[i+cha]-W[i-1];
			}
		}
		
		//for(int i=1;i<n+1;i++){for(int j:Cost[i])System.out.print(j+" ");System.out.println();}
		
		System.out.println(Cost[1][n]);
	}
}
