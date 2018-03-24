package xiaoxueqi;
import java.util.*;

public class Csp16034_40 {
	public static Set<Integer> set=new HashSet<Integer>();
	public static List<Integer> maxtime=new ArrayList<Integer>();// 1到i的劳累度
	public static List<Boolean> visited=new ArrayList<Boolean>();;// 是否已经过
	public static int Max = Integer.MAX_VALUE;
	private static List<LinkedList<Edge2>> list = new ArrayList<LinkedList<Edge2>>();// 邻接表

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 路口数
		int m = sc.nextInt();// 道路数

		for (int i = 0; i < n + 1; i++) {
			list.add(new LinkedList<Edge2>());
			maxtime.add(Max);
			visited.add(false);
		}
		
		
		int lmaxtime = 0;
		int a, b;
		int len;
		for (int i = 1; i <= m; i++) {

			a = sc.nextInt();
			b = sc.nextInt();
			len = sc.nextInt();
			list.get(a).push(new Edge2(a, b, len));
			list.get(b).push(new Edge2(b, a, len));
		}
		

		maxtime.set(1, 0);
		visited.set(1, true);
		int now = 1;
		set.add(now);
		while (!visited.get(n)) {// 只要n没被访问就一直走
			// 加边
			 //System.out.println("now=" + now + " ");
			for (Edge2 edge : list.get(now)) {
				
				int i = edge.end;
				if (visited.get(i))
					continue;
				set.add(i);
				if (maxtime.get(i) > maxtime.get(now)) {
					maxtime.set(i, Math.max(maxtime.get(now),edge.len));
					// System.out.prlongln("修改"+i+"的maxtime为"+maxtime[i]);
				}
				
			}
			set.remove(now);
			lmaxtime = 0;
			for (int i1 :set) {
				if (!visited.get(i1) && maxtime.get(i1) < maxtime.get(lmaxtime)) {
					lmaxtime = i1;
				}
			}
			if (lmaxtime == 0)
				break;
			now = lmaxtime;
			visited.set(now,true);

		}

		System.out.println(maxtime.get(n));

	}

}

class Edge2 implements Comparable<Edge2>{
	public int len;
	public int start;
	public int end;

	public Edge2(int start, int end, int len) {
		this.start = start;
		this.end = end;
		this.len = len;
	}

	@Override
	public int compareTo(Edge2 o) {
		// TODO Auto-generated method stub
		return this.len-o.len;
	}
}

