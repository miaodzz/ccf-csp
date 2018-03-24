import java.util.*;
public class Csp15034 {
	static int[] mhigh;
	static int[] mlength;
	static Nodd[] nodes;
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt()+n;
		nodes=new Nodd[m+1];
		mhigh=new int[m+1];
		mlength=new int[m+1];
		for(int i=0;i<=m;i++){
			nodes[i]=new Nodd();
		}
		for(int son=2;son<=n;son++){
			int father=sc.nextInt();
			nodes[son].father=father;
			nodes[father].son.add(son);
		}
		for(int son=n+1;son<=m;son++){
			int father=sc.nextInt();
			nodes[son].father=father;
			nodes[father].son.add(son);
		}
		for(int i=m;i>0;i--){
			if(nodes[i].son.size()==0) {mhigh[i]=0;mlength[i]=0; continue;}
			int max=-1;int second=-1;int maxl=0;
			for(int ison:nodes[i].son){
				if(mhigh[ison]>second){
					if(mhigh[ison]>max){
						second=max;
						max=mhigh[ison];
					}
					else second=mhigh[ison];
				}
				if(mlength[ison]>maxl) maxl=mlength[ison];
			}
			mhigh[i]=max+1;
			mlength[i]=Math.max(maxl,max+second+2);
		}
		System.out.println(mlength[1]);
	}
}
class Nodd{
	int father;
	ArrayList<Integer> son=new ArrayList<Integer>();
}