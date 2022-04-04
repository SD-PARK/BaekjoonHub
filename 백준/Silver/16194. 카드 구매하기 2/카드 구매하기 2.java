import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] P = new int[N+1];
		int[] D = new int[N+1];
		for(int i=1; i<=N; i++) {
			P[i] = sc.nextInt();
			D[i] = P[i];
			for(int j=1; j<=i; j++)
				D[i] = Math.min(D[i], D[i-j] + P[j]);
		}
		System.out.print(D[N]);
	}
}