package xiaoxueqi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Csp15124_50pq_al {
	static int count[];
	static ArrayList<ArrayList<Integer>> G;
	static boolean vis[][];
	static int n,m;
	static LinkedList<Integer> q=new LinkedList<Integer>();
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		G=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++){
			G.add(new ArrayList<Integer>());
		};
		count=new int[n];
		vis=new boolean[n][n];
		for(int i=0;i<m;i++){
			int a=sc.nextInt()-1, b=sc.nextInt()-1;
			G.get(a).add(b);G.get(b).add(a);
			++count[a];++count[b];
		}
		
		
		for(int i=0;i<n;i++){
			Collections.sort(G.get(i));
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
		
		for(int v:G.get(u)){
			if(!vis[u][v]){
				vis[u][v]=vis[v][u]=true;
				euler(v);
				q.addFirst(v+1);
			}
			
		}
		
		
	}
}



