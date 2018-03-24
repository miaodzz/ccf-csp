
import java.util.Scanner;

public class Csp17094 {
	static boolean[][] road;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		road = new boolean[n + 1][n + 1];
		for (long i = 0; i < m; i++) {
			road[sc.nextInt()][sc.nextInt()] = true;
		}
/*
		for(long i=1;i<=n;i++){
			for(long j=1;j<=n;j++){
				System.out.prlong(road[i][j]+" ");
			}
			System.out.prlongln();
		}
		*/
		for (int k = 1; k <= n; ++k) {
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					if(i!=j&&i!=k&&k!=j)
						road[i][j] = road[i][j] | (road[i][k] & road[k][j]);
				}
				
				
			}
			/*
			System.out.prlongln(k);
			for(long i1=1;i1<=n;i1++){
				for(long j=1;j<=n;j++){
					System.out.prlong(road[i1][j]+" ");
				}
				System.out.prlongln();
			}*/
			
		}
		int ans = 0;
		
		for (int k = 1; k <= n; ++k) {
			for (int i = 1; i <= n; ++i) {
				if (i!=k&&!road[k][i]&&! road[i][k]) {
					ans++;break;
				}

			}

		}
		
		System.out.println(n-ans);
	}
}
