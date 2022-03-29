import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[][] D = new long[K+1][N+1];
		int mod = 1_000_000_000;
		D[0][0] = 1;
		for(int k=1; k<=K; k++)
			for(int n=0; n<=N; n++)
				for(int i=0; i<=n; i++)
					D[k][n] = (D[k][n] + D[k-1][n-i]) % mod;
		System.out.print(D[K][N]);
	}
}