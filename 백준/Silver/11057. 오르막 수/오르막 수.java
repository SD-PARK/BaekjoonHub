import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] D = new int[N+1][10];
		for(int i=0; i<10; i++)
			D[1][i] = 1;
		for(int i=2; i<=N; i++)
			for(int j=0; j<10; j++)
				for(int k=j; k>=0; k--) {
					D[i][j] += D[i-1][k];
					D[i][j] %= 10007;
				}
		int sum = 0;
		for(int i:D[N])
			sum = (sum + i) % 10007;
		System.out.print(sum);
	}
}