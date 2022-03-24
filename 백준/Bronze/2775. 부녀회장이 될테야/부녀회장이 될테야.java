import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[15][15];
		for (int i = 0; i < 15; i++) {
			a[i][1] = 1;
			a[0][i] = i;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				a[i][j] = a[i - 1][j] + a[i][j - 1];
			}
		}

		for (int T = sc.nextInt(); T > 0; T--) {
			int k = sc.nextInt(), n = sc.nextInt();
			System.out.println(a[k][n]);
		}
	}
}