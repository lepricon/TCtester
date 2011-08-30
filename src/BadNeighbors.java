import java.util.HashMap;

public class BadNeighbors {

	int[] data;
	
	int maxInInterval(int a, int b) {
		int[] s = new int[data.length];

		for (int i = a; i <= b; i++) {
			int max = s[i] = data[i];
			for (int j = a; j < i-1; j++) {
				if (s[j] + data[i] > max) {
					max = s[j] + data[i];
				}
			}
			s[i] = max;
		}

		return s[b];
	}
	
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	int go(int a, int b) {
		int key = 100*a + b;
		if (map.containsKey(key)) return map.get(key);
		if (a > b) return 0;
		map.put(key, Math.max(go(a+1, b), data[a] + go(a+2, b)));
		return map.get(key);
	}
	
	int maxDonations(int[] donations) {
		data = donations;
		int n = data.length;
		
		return Math.max(maxInInterval(0, n-2), maxInInterval(1, n-1));
		//return Math.max(go(0, n-2), go(1, n-1));
	}
	
	public static void main(String[] args) {
		BadNeighbors bn = new BadNeighbors();
		int[] data = { 7, 7, 7, 7, 7, 7, 7 };
		int result = bn.maxDonations(data);
		System.out.println(result);
	}

}
