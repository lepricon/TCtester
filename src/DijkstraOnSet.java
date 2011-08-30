
public class DijkstraOnSet {
	public int[] getMinimalPath() {
		
	}

	public static void main(String[] args) {
		DijkstraOnSet dos = new DijkstraOnSet();
		int[][] G = {{0,  1,  2, -1},
					 {1,  0,  3,  5},
					 {2,  3,  0, -1},
					 {-1, 1,  2,  0}};
		}
		System.out.println(dos.getMinimalPath());
	}

}
