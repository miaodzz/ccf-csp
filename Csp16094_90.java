import java.util.*;

public class Csp16094_90 {
	static List<Set<Edge4>> list = new ArrayList<Set<Edge4>>(100001);
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static int[] dist;
	static int[] ad;
	static boolean[] vis;
	static int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 初始化
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			list.add(new HashSet<Edge4>());
		}
		dist = new int[n + 1];// 单源点最短路径
		ad = new int[n + 1];// 增加的路
		vis = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			list.get(a).add(new Edge4(b, w));
			list.get(b).add(new Edge4(a, w));
		}
		int now;
		int ans = 0;
		pq.add(new Node(1, 0, 0));
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (vis[node.end])
				continue;
			now = node.end;
			vis[now] = true;
			dist[now] = node.dis;
			ans += node.ad;
			for (Edge4 edge : list.get(now)) {
				list.get(edge.b).remove(new Edge4(now, edge.len));
				if (!vis[edge.b]) {
					pq.add(new Node(edge.b, edge.len, dist[now] + edge.len));
				}
			}

		}

		System.out.println(ans);
	}
}

class Edge4 {
	int b, len;

	public Edge4(int y, int z) {
		b = y;
		len = z;
	}

	@Override
	public boolean equals(Object obj) {
		Edge4 other = (Edge4) obj;
		if (this.b == other.b && this.len == other.len) {
			return true;
		}
		return false;
	}
}

class Node implements Comparable<Node> {
	int end;
	int ad;
	int dis;

	public Node(int end, int ad, int dis) {
		this.end = end;
		this.ad = ad;
		this.dis = dis;
	}

	@Override
	public int compareTo(Node o) {
		if (this.dis > o.dis)
			return 1;
		if (this.dis < o.dis)
			return -1;
		if (this.ad > o.ad)
			return 1;
		if (this.ad == o.ad)
			return 0;
		return -1;
	}

}
