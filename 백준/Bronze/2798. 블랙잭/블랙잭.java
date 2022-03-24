import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(), M = scan.nextInt(), s = 0;
		int[] c = new int[N];
		for (int i = 0; i < N; i++)
			c[i] = scan.nextInt();
		for (int i = 0; i < N - 2; i++)
			for (int j = i + 1; j < N - 1; j++)
				for (int k = j + 1; k < N; k++) {
					int sum = c[i] + c[j] + c[k];
					s = (M - s > M - sum && M - sum >= 0) ? sum : s;
				}
		System.out.println(s);
	}
}