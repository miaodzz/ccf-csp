import java.util.*;
public class Csp15124_70 {
	static int count[];
	static boolean G[][];
	static int n,m;
	static LinkedList<Integer> q=new LinkedList<Integer>();
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		G=new boolean[n][n];
		count=new int[n];
		for(int i=0;i<m;i++){
			int a=sc.nextInt()-1, b=sc.nextInt()-1;
			G[a][b]=G[b][a]=true;
			++count[a];++count[b];
		}
		
		
		
		int i;
		
		int k=0;
		if((count[0]&0x01)==1){
			for(i=1;i<n;i++){
				if((count[i]&0x01)==1) k++;
				if(k==2) {
					System.out.println(-1);return;
				}
			}
			
		}else{
			for(i=1;i<n;i++){
				if((count[i]&0x01)==1){
					System.out.println(-1);return;
				}
			}
		}
		
		
		euler(0);
		q.addFirst(1);
		if(q.size()!=m+1){
			System.out.println(-1);return;
		} 
		for(int k1:q) System.out.print(k1+" ");
		
	}
	
	public static void euler(int u){
		
		for(int v=0;v<n;v++){
			if(G[u][v]){
				G[u][v]=G[v][u]=false;
				
				euler(v);
				q.addFirst(v+1);
			}
		}
		
	}
}
