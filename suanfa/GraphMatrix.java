package suanfa;

public class GraphMatrix {
	int MAXN = 1000;
	int closest[] = new int[MAXN];
	int lowcost[] = new int[MAXN];
	int m;// m为节点的个数
	int G[][] = new int[MAXN][MAXN];// 邻接矩阵

	public static void main(String args[]) {

	}

	int prim() {
		for (int i = 0; i < m; i++) {
			lowcost[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < m; i++) {
			closest[i] = 0;
		}
		closest[0] = -1;// 加入第一个点，-1表示该点在集合U中，否则在集合V中
		int num = 0, ans = 0, e = 0;// e为最新加入集合的点
		while (num < m - 1)// 加入m-1条边
		{
			int micost = Integer.MAX_VALUE, miedge = -1;
			for (int i = 0; i < m; i++) {//遍历所有的点，如果有因为加入新点而变近的，修改，取最近
				if (closest[i] != -1) {// 不在集合U里
					int temp = G[e][i];
					if (temp < lowcost[i]) {
						lowcost[i] = temp;
						closest[i] = e;
					}
					if (lowcost[i] < micost)
						micost = lowcost[miedge = i];
				}
			}
			ans += micost;
			closest[e = miedge] = -1;
			num++;
		}
		return ans;//ans是最小生成树的值，树可以通过print closet获得。
	}
}