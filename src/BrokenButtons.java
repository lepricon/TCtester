
public class BrokenButtons {
	int minPresses(int page, int[] broken) {
		if (page == 100) return 0;
		
		int minPresses = 1000000;
		for (int i = 0; i <= 500000; i++) {
			String pageStr = Integer.toString(i);
			boolean hasBad = false;
			for (int j = 0; j < broken.length; j++) {
				if (pageStr.indexOf('0' + broken[j]) > -1) {
					hasBad = true;
					break;
				}
			}
			if (!hasBad) {
				int presses = Math.abs(i - page) + pageStr.length();
				if (minPresses > presses) {
					minPresses = presses;
				}
			}
		}
		return minPresses;
	}

	public static void main(String[] args) {
		BrokenButtons bb = new BrokenButtons();
		int page = 80000;
		int[] broken = {8, 9};
		System.out.println(bb.minPresses(page, broken));
	}

}
