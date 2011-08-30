import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class DijkstraOnSet {
	final int INF = 10000000;

	public class PairInts implements Comparable<PairInts> {
		public PairInts(int av, int ad) {
			v = av; d = ad;
		}
		int v, d;

		@Override
		public int compareTo(PairInts o) {
			if (v != o.v) return v - o.v;
			if (d != o.d) return d - o.d;
			return 0;
		}
	}

	public int getMinimalPath(int[][] G) {
		int N = G.length;
		int[] D = new int[N];
		int[] path = new int[N];
		Arrays.fill(D, INF);
		SortedSet<PairInts> Q = new TreeSet<DijkstraOnSet.PairInts>();
		D[0] = 0;
		path[N-1] = N-1;
		Q.add(new PairInts(0, 0));
		while ( !Q.isEmpty() ) {
			PairInts top = Q.first();
			Q.remove(Q.first());

			for (int i = 1; i < N; i++) {
				if (G[top.v][i] > 0 && D[i] > D[top.v] + G[top.v][i]) {
					if (D[i] != INF) {
						Q.remove(new PairInts(i, D[i]));
					}
					D[i] = D[top.v] + G[top.v][i];
					path[i-1] = top.v;
					Q.add(new PairInts(i, D[i]));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
		return D[N-1];
	}

	public static void main(String[] args) {
		DijkstraOnSet dos = new DijkstraOnSet();
		int[][] G = {{0,  1,  6, -1},
					 {1,  0,  3,  7},
					 {6,  3,  0,  2},
					 {-1, 7,  2,  0}};
		System.out.println(dos.getMinimalPath(G));
	}
}
