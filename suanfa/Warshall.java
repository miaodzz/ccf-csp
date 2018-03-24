package suanfa;

import java.util.*;
import java.util.Scanner;

public class Warshall {
	static boolean[][] road;
	static ArrayList<ArrayList<Integer>> listfrom = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> listto = new ArrayList<ArrayList<Integer>>();

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		road = new boolean[n + 1][n + 1];
		int a;
		int b;
		for (int i = 0; i <= n; i++) {
			listfrom.add(new ArrayList<Integer>());
			listto.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			road[a = sc.nextInt()][b = sc.nextInt()] = true;
			listfrom.get(a).add(b);// a->b from a
			listto.get(b).add(a); // b->a to a
		}

		for (int k = 1; k <= n; ++k) {
			for (int i : listto.get(k)) {
				for (int j : listfrom.get(k)) {
					if (!road[i][j]) {
						road[i][j] = true;
						listto.get(j).add(i);
						listfrom.get(i).add(j);
					}
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j < n; ++j) {
				if (i != j && !road[i][j] && !road[j][i]) {
					++ans;
					break;
				}

			}
		}
		System.out.println(n - ans);
	}
}
