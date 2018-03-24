
import java.util.*;

public class Csp15094 {
	public static int DFN[];
	public static int LOW[];
	public static int stack[];
	public static int heads[];
	public static int visit[];	
	public static int cnt, tot, index,ans;
	public static EdgeT[] edge;

	static void add(int x, int y) {
		edge[++cnt].next = heads[x];
		edge[cnt].v = y;
		heads[x] = cnt;
		return;
	}

	static void tarjan(int x)// 代表第几个点在处理。递归的是点。
	{
		DFN[x] = LOW[x] = ++tot;// 新进点的初始化。
		stack[++index] = x;// 进站
		visit[x] = 1;// 表示在栈里
		for (int i = heads[x]; i != -1; i = edge[i].next) {
			if (DFN[edge[i].v] == 0) {// 如果没访问过
				tarjan(edge[i].v);// 往下进行延伸，开始递归
				LOW[x] = Math.min(LOW[x], LOW[edge[i].v]);// 递归出来，比较谁是谁的儿子／父亲，就是树的对应关系，涉及到强连通分量子树最小根的事情。
			} else if (visit[edge[i].v] != 0) { // 如果访问过，并且还在栈里。
				LOW[x] = Math.min(LOW[x], DFN[edge[i].v]);// 比较谁是谁的儿子／父亲。就是链接对应关系
			}
		}
		if (LOW[x] == DFN[x]) // 发现是整个强连通分量子树里的最小根。
		{
			int anst=0;
			do {
				//System.out.printf("%d ", stack[index]);
				++anst;
				visit[stack[index]] = 0;
				index--;
			} while (x != stack[index + 1]);// 出栈，并且输出。
			ans+=(anst*(anst-1)/2);
			//System.out.printf("\n");
		}
		return;
	}

	public static void main(String[] args) {
		

		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		DFN=new int[n+1];
		LOW=new int[n+1];
		stack=new int[n+1];
		heads=new int[n+1];
		visit=new int[n+1];
		edge=new EdgeT[m+1];
		Arrays.fill(heads, -1);		
		for(int i=0;i<=m;i++){
			edge[i]=new EdgeT();
		}
	
		for (int i = 1; i <= m; i++) {

			add(sc.nextInt(), sc.nextInt());
		}
		for (int i = 1; i <= n; i++)
			if (DFN[i] == 0)
				tarjan(i);// 当这个点没有访问过，就从此点开始。防止图没走完

		System.out.println(ans);
	}
}

class EdgeT {
	int v, next;

	public EdgeT(int v, int next) {
		this.v = v;
		this.next = next;
	}

	public EdgeT() {
		// TODO Auto-generated constructor stub
	}
}
