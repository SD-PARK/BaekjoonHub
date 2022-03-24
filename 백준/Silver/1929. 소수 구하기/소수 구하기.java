import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt(), N = scan.nextInt();
		boolean[] s = new boolean[N + 1];

		for (int i = (int) Math.sqrt(N); i > 1; i--)
			for (int j = 2; i * j <= N; j++)
				s[i * j] = true;

		for (int i = M < 3 ? 2 : M; i <= N; i++)
			System.out.print(s[i] == false ? i + "\n" : "");
	}
}