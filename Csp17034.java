import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Csp17034 {
    private int[] flag;

    private int unionFind(int e) {
        while (flag[e] != e) {
            e = flag[e];
        }
        return e;
    }

    private static class Rode implements Comparable<Rode>{
        private int a;
        private int b;
        private int w;
        public Rode(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Csp17034.Rode o) {
            return this.w-o.w;
        }
    }

    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);
        int N = In.nextInt();
        int m = In.nextInt();
        int ans = 0;
        Csp17034 memb = new Csp17034();
        memb.flag = new int[N + 10];
        ArrayList<Rode> roads = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            memb.flag[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = In.nextInt();
            int b = In.nextInt();
            int w = In.nextInt();

            roads.add(new Rode(a, b, w));
        }

        Collections.sort(roads);
        for (int i = 0; i < m; i++) {
            int x = memb.unionFind(roads.get(i).a);
            int y = memb.unionFind(roads.get(i).b);
            if (x != y) {
                if (x > y)
                    memb.flag[x] = y;
                else
                    memb.flag[y] = x;
            }
            ans = roads.get(i).w;

            if (memb.unionFind(N) == 1)
                break;
        }
        System.out.println(ans);
    }
}