import java.util.StringTokenizer;


public class AvoidRoads {
	long numWays(int width, int height, String[] bad) {
		int[][] impassable = new int[width+1][height+1];
		long[][] ways = new long[width+1][height+1];
		for (int i = 0; i < bad.length; i++) {
			StringTokenizer st = new StringTokenizer(bad[i]);
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			if (x1 == x2) impassable[x1][y1] = impassable[x2][y2] = 1;
			if (y1 == y2) impassable[x1][y1] = impassable[x2][y2] = -1;
		}
		ways[0][0] = 1;
		for (int i = 0; i < width+1; i++) {
			for (int j = 0; j < height+1; j++) {
				if (j == 0 && i > 0 && impassable[i][j] != -1) {
					ways[i][j] += ways[i-1][j];
				}
				else if (i == 0 && j > 0 && impassable[i][j] != 1) {
					ways[i][j] += ways[i][j-1];
				}
				else if (i > 0 && j > 0) {
					if (impassable[i][j] == 1) {
						ways[i][j] += ways[i-1][j];
					}
					else if (impassable[i][j] == -1) {
						ways[i][j] += ways[i][j-1];
					}
					else {
						ways[i][j] += ways[i-1][j] + ways[i][j-1];	
					}
				}
			}
		}
		
		return ways[width][height];
	}

	public static void main(String[] args) {
		int width    = 6;
		int height   = 6;
		String[] bad = {"0 0 0 1","6 6 5 6"};
		AvoidRoads ar = new AvoidRoads();
		System.out.println(ar.numWays(width, height, bad));
	}

}
