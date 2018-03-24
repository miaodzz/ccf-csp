import java.util.*;

public class Csp17092 {
	static List<Use> uses = new ArrayList<Use>();
	static int[] list;
	static int[] weizhi;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	public static void main(String[] args) {

		int N;// 教室数目
		int K;// K位老师

		// 初始化
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int w, s, c;
		for (int i = 0; i < K; i++) {
			w = sc.nextInt();
			s = sc.nextInt();
			c = sc.nextInt();
			uses.add(new Use(w, s, s + c));
		}
		list = new int[N + 1];
		weizhi = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = i;
			weizhi[i] = i;
		}
		// pq记录所有当前的空位
		Collections.sort(uses);
		// 两种思路 1.每个时间检测有没有
		// 2.每个Use检查时间然后挂过去
		int nowpos;
		for (int i = 1; i < 11000; i++) {
			Iterator<Use> it = uses.iterator();
			while (it.hasNext()) {
				Use u = it.next();
				if (u.end == i) {
					nowpos = pq.poll();// 从pq中取出值最小的
					list[nowpos] = u.windex;// 放回
					weizhi[u.windex] = nowpos;
					// System.out.println("钥匙" + u.windex + "放回" + nowpos + "时间"
					// + i);
					it.remove();
				}

			}
			it = uses.iterator();
			while (it.hasNext()) {
				Use u = it.next();
				if (u.start == i) {
					nowpos = weizhi[u.windex];
					// System.out.println("钥匙" + u.windex + "由位置" + nowpos +
					// "在时间" + i + "借出");
					list[nowpos] = -1;
					pq.add(nowpos);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			switch (list[i]) {
			case -1:
				System.out.print("X ");
				break;
			default:
				System.out.print(list[i] + " ");
			}
		}

	}
}

class Use implements Comparable<Use> {
	public int windex;
	int start;
	int end;

	public Use(int windex, int start, int end) {
		this.windex = windex;
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Use o) {
		return this.windex - o.windex;
	}

}