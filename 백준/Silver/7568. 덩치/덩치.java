import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] h = new int[N][3];
		for (int i = 0; i < N; i++) {
			h[i][0] = s.nextInt();
			h[i][1] = s.nextInt();
			h[i][2] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				h[i][2] += (h[j][0]>h[i][0] && h[j][1]>h[i][1])?1:0;
			System.out.print(h[i][2] + " ");
		}
		
	}
}