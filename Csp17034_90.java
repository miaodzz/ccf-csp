import java.util.*;

public class Csp17034_90 {
	static PriorityQueue<Edge3> list = new PriorityQueue<Edge3>(200001);// 所有的边
	static int pre[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 路口数
		int m = sc.nextInt();// 道路数

		int a, b, c;
		for (int i = 0; i < m; i++) {
			list.add(new Edge3(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		pre = new int[n + 1];
		for (int i = 0; i < pre.length; i++) {
			pre[i] = i;
		}

		Edge3 edge = new Edge3(0, 0, 0);
		while (!list.isEmpty()) {
			edge = list.poll();
			int s = find(edge.start);//这里一定要
			int e = find(edge.end);

			// System.out.println(edge.start+" "+edge.end+" "+edge.len);

			if (s < e) {
				pre[e] = s;
			} else {
				pre[s] = e;
			}

			if (find(n) == 1) {
				break;
			}

		}
		System.out.println(edge.len);
	}

	public static int find(int x) {// 并查集 find[i]相同就代表是同一个子树
		 int fx = x;  
	        while(pre[fx] != fx){  
	            fx = pre[fx];  
	        }  
	        int i = x,j;  
	        while(pre[i]!=fx){  
	            j = pre[i];  
	            pre[i] = fx;  
	            i = j;  
	        }  
	        return fx;  
	}

}

class Edge3 implements Comparable<Edge3> {

	int start, end, len;

	public Edge3(int s, int e, int l) {
		start = s;
		end = e;
		len = l;
	}

	@Override
	public int compareTo(Edge3 o) {
		return this.len - o.len;
	}
}