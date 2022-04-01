import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), n;
		long[][] D = new long[100001][4];
		long mod = 1_000_000_009;
		D[0][1] = 1;
		D[1][1] = 1;
		D[2][2] = 1;
		for(int i=3; i<100001; i++) {
			D[i][1] = (D[i-1][2] + D[i-1][3]) % mod;
			D[i][2] = (D[i-2][1] + D[i-2][3]) % mod;
			D[i][3] = (D[i-3][1] + D[i-3][2]) % mod;
		}
		while(T-->0) {
			n = sc.nextInt();
			System.out.println((D[n][1] + D[n][2] + D[n][3]) % mod);
		}
	}
}