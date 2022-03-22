import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N+1];
		int[] P = new int[N+1];
		for(int i=1; i<=N; i++)
			P[i] = sc.nextInt();
		for(int i=1; i<=N; i++)
			for(int j=1; j<=i; j++)
				D[i] = Math.max(D[i], D[i-j]+P[j]);
		System.out.print(D[N]);
	}
}