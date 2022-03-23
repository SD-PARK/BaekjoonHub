import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long mod = 1_000_000_000;
		long[][] D = new long[N+1][10];
		D[1][0] = 0;
		for(int i=1; i<10; i++)
			D[1][i] = 1;
		for(int i=2; i<=N; i++) {
			for(int j=0; j<10; j++) {
				if(j==0)
					D[i][j] = D[i-1][1];
				else if(j==9)
					D[i][j] = D[i-1][8];
				else
					D[i][j] = D[i-1][j-1] + D[i-1][j+1];
				
				D[i][j] %= mod;
			}
		}
		long sum = 0;
		for(Long i:D[N])
			sum += i;
		System.out.print(sum % mod);
	}
}