
public class FiveKeys {

	public int getPermittedPositions(int n) {
		Permutation p = new Permutation(n);
		int counter = 0;
		while (p.hasNext()) {
			p.next(); // first is always not permitted
			boolean isPermitted = true;
			for (int i = 0; i < n; i++) {
				if (p.indexOf(i) == i) {
					isPermitted = false;
					break;
				}
			}
			if (isPermitted) counter++;
		}
		return counter;
	}
	
	public static void main(String[] args) {
		System.out.println(new FiveKeys().getPermittedPositions(5));
	}

}
