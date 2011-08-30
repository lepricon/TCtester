public class CyclicWords {

	boolean areEqual(String a, String b) {
		if (a.length() != b.length()) return false;
		int len = a.length();
		for (int i = 0; i < a.length(); i++) {
			boolean areEual = true;
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt((i+j)%len) != b.charAt(j)) {
					areEual = false;
					break;
				}
			}
			if (areEual) return true;
		}
		return false;
	}
	
	
	int differentCW(String[] words) {
		int N = words.length;
		int[] checked = new int[N];
		int total = 0;
		for (int i = 0; i < N; i++) {
			if (checked[i] > 0) continue;
			for (int j = i+1; j < N; j++) {
				if (areEqual(words[i], words[j])) {
					checked[i] = checked[j] = i+1;
				}
			}
			total++;
		}

		return total;
	}
	
	public static void main(String[] args) {
		CyclicWords bn = new CyclicWords();
		String[] data = {"aaaa", "aaa", "aa", "aaaa", "aaaaa"};
		int result = bn.differentCW(data);
		System.out.println(result);
	}	
}