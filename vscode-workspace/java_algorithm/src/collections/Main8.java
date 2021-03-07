package collections;
public class Main8 {
	public static void main(String[] args) {
		int[][] mat = new int[2][6];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if (i == 0) {
					mat[i][j] = (j + 1) * 2 - 1;
				} else {
					mat[i][j] = j * 2;
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		doSomething(mat);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void doSomething(int[][] mat) {
		for (int row = 0; row < mat.length; row++)
			for (int col = 0; col < mat[0].length; col++)
				mat[row][col] = mat[row][mat[0].length - 1 - col];
	}

}
