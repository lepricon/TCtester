public class Knapsack {

	public int[] mostValuableTupleUnbounded(int[] weights, int[] costs, int W) {
		int[] d = new int[W + 1];
		int n = weights.length;
		int[][] products = new int[W+1][2];
		
		d[0] = 0;
		for (int w = 1; w <= W; w++) {
			d[w] = d[w-1];
			for (int i = 0; i < n; i++) {
				if (w >= weights[i]) {
					if (d[w - weights[i]] + costs[i] > d[w]) {
						d[w] = d[w - weights[i]] + costs[i];
						products[w][0] = w - weights[i];
						products[w][1] = i;
					}
				}
			}
		}
		
		int[] result = new int[n];
		int w = W;
		while (w > 0) {
			result[products[w][1]]++;
			w = products[w][0];
		}
		
		return result;
	}
	
	public int[] mostValuableTuple0_1(int[] weights, int[] costs, int W) {
		int n = weights.length;
		int[][] d = new int[W+1][n+1];
		int[][] products = new int[W+1][n+1];
		
		for (int i = 0; i <= W; i++) d[i][0] = 0;
		for (int j = 0; j <= n; j++) d[0][j] = 0;
		for (int j = 1; j <= n; j++) {
			for (int w = 1; w <= W; w++) {
				d[w][j] = d[w][j - 1];
				if (w >= weights[j-1]) {
					if (d[w - weights[j-1]][j-1] + costs[j-1] > d[w][j]) {
						d[w][j] = d[w - weights[j-1]][j-1] + costs[j-1];
						products[w][j] = w - weights[j-1];
					}
				}
			}
		}

		for (int i = 0; i <= W; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(products[i][j] + " ");
			}
			System.out.println();
		}

		int[] result = new int[n];
		int w = W;
		while (w > 0) {
			result[products[w][0]]++;
			w = products[w][1];
		}

		return result;
	}

	public static void main(String[] args) {
		Knapsack ks = new Knapsack();
		int[] weights = {12, 2, 1, 4, 1};
		int[] costs = {4, 2, 1, 10, 2};
		int W = 15;
		int[] result = ks.mostValuableTuple0_1(weights, costs, W);
		for (int i = 0; i < weights.length; i++) {
			System.out.print(result[i] + " ");	
		}
	}

}
