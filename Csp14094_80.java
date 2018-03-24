import java.util.*;

public class Csp14094_80 {
	static LinkedList<Integer> q = new LinkedList<Integer>();
	static boolean tmp[][];
	static boolean vis[][];
	static ArrayList<Noode> no = new ArrayList<Noode>(100001);
	static int num[][];
	static int MAX = Integer.MAX_VALUE;
	static int time = 0;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static long ans;// i店到k单用户的最短路径

	public static void main(String args[]) {

		// 初始化
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int d = sc.nextInt();
		int r, c;
		vis = new boolean[n][n];
		num = new int[n][n];
		tmp = new boolean[n][n];

		

		for (int i = 0; i < m; i++) {
			r = sc.nextInt();
			c = sc.nextInt();
			q.add(r - 1);
			q.add(c - 1);
		}
		int count=0;
		for (int i = 0; i < k; i++) {
			r = sc.nextInt();
			c = sc.nextInt();
			if (num[r-1][c-1] == 0) {
				count++;
			}
			num[r - 1][c - 1] += sc.nextInt();
		}
		
		for (int i = 0; i < d; i++) {
			vis[sc.nextInt() - 1][sc.nextInt() - 1] = true;
		}
		
		q.add(-2);
		 //System.out.println(count);
		int x;
		int y;
		while (true) {
			x = q.poll();
			if (x == -2) {
				q.add(-2);
				x = q.poll();
				++time;
				for (int i = 0; i < n; ++i)
					Arrays.fill(tmp[i], false);
			}

			y = q.poll();
			// int t=q.poll();
			if (vis[x][y]) {
				continue;
			}
			vis[x][y] = true;
			if (num[x][y] > 0) {
				no.add(new Noode(x, y, num[x][y], time));
				 //System.out.println(num[x][y]+" "+time);
				count--;
				if (count == 0)
					break;
			}
			for (int i = 0; i < 4; ++i) {
				if (x + dx[i] > -1 && x + dx[i] < n && y + dy[i] > -1 && y + dy[i] < n 
						&& !tmp[x + dx[i]][y + dy[i]] && !vis[x + dx[i]][y + dy[i]]) {
					tmp[x + dx[i]][y + dy[i]] = true;
					q.add(x + dx[i]);
					q.add(y + dy[i]);
					// q.add(i);
				}

			}

		}
		for (Noode node : no) {
			ans += (node.num * node.dist);
		}
		System.out.println(ans);

	}

}

class Noode {
	public Noode(int x2, int y2, int i, int j) {
		x = x2;
		y = y2;
		num = i;
		dist = j;
	}

	int x, y;
	int num;
	int dist;
}