import java.util.*;

public class Csp16044 {
	static int start[][];
	static int end[][];
	static int MAX = Integer.MAX_VALUE;
	static int time = 0;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static boolean tmp[][];
	public static void main(String args[]) {

		// 初始化
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		int r, c, a, b;
		start = new int[n][m];
		end = new int[n][m];
		tmp=new boolean[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(start[i], MAX);
			Arrays.fill(end[i], -1);
		}
		for (int i = 0; i < t; i++) {
			r = sc.nextInt();
			c = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			start[r - 1][c - 1] = a;
			end[r - 1][c - 1] = b;
		}
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(-2);
		q.add(0);
		q.add(0);

		int x;
		int y;
		Set<Integer> set = new HashSet<Integer>();
		while (true) {
			x = q.poll();
			if (x == -2) {
				q.add(-2);
				x = q.poll();
				++time;
				for(int i=0;i<n;++i) Arrays.fill(tmp[i], false);
			}
			y = q.poll();
			if (x == n - 1 && y == m - 1)
				break;
			for (int i = 0; i < 4; ++i) {
				if (x + dx[i] > -1 && x + dx[i] < n && y + dy[i] > -1 && y + dy[i] < m
						&& (start[x + dx[i]][y + dy[i]] > time || end[x + dx[i]][y + dy[i]] < time)
						&&tmp[x+dx[i]][y+dy[i]]==false) {
					tmp[x+dx[i]][y+dy[i]]=true;
					q.add(x + dx[i]);
					q.add(y + dy[i]);
				}

			}

		}
		System.out.println(time - 1);
	}

}
