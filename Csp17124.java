import java.util.*;

public class Csp17124 {
	public static double dist[];// 当前到i走了多少小道。
	public static double exp[];// 1到i的劳累度
	public static boolean visited[];// 是否已经过
	public static double Max = Integer.MAX_VALUE;
	private static List<LinkedList<Edge1>> list = new ArrayList<LinkedList<Edge1>>();// 邻接表

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 路口数
		int m = sc.nextInt();// 道路数

		for (int i = 0; i < n + 1; i++) {
			list.add(new LinkedList<Edge1>());
		}
		dist = new double[n + 1];// 当前到i走了多少小道。
		exp = new double[n + 1];// 1到i的劳累度
		visited = new boolean[n + 1];// 是否已经过

		int lexp = 0;
		int t, a, b;
		double len;
		for (int i = 1; i <= m; i++) {

			t = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			len = sc.nextInt();
			list.get(a).push(new Edge1(t, a, b, len));
			list.get(b).push(new Edge1(t, b, a, len));
		}

		Arrays.fill(exp, Max);
		Arrays.fill(dist, 0);
		Arrays.fill(visited, false);

		dist[1] = 0;
		exp[1] = 0;
		visited[1] = true;
		int now = 1;

		while (!visited[n]) {// 只要n没被访问就一直走
			// 加边
			double tmpexp = Max;

			// System.out.println("now=" + now + " ");
			for (Edge1 edge : list.get(now)) {
				int i = edge.end;
				if (visited[i])
					continue;

				if (edge.xiaodao == 1) {
					tmpexp = exp[now] - Math.pow(dist[now], 2) + Math.pow(dist[now] + edge.len, 2);
					if (tmpexp < exp[i]) {
						dist[i] = dist[now] + edge.len;
						exp[i] = tmpexp;
						// System.out.println("修改"+i+"的exp为"+exp[i]+"
						// 修改dist为"+dist[i]);
					}
				} else {
					tmpexp = exp[now] + edge.len;
					if (exp[now] + edge.len < exp[i]) {
						dist[i] = 0;
						exp[i] = tmpexp;
						// System.out.println("修改"+i+"的exp为"+exp[i]);
					}
				}

			}

			lexp = 0;
			for (int i1 = 1; i1 <= n; i1++) {
				if (!visited[i1] && exp[i1] < exp[lexp]) {
					lexp = i1;
				}
			}
			if (lexp == 0)
				break;
			now = lexp;
			visited[now] = true;

		}

		System.out.print((long) exp[n]);

	}

}

class Edge1 {
	public int xiaodao = 1;
	public double len;
	public int start;
	public int end;

	public Edge1(int xiaodao, int start, int end, double len) {
		this.xiaodao = xiaodao;
		this.start = start;
		this.end = end;
		this.len = len;
	}
}