import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N+1];
		int[] D = new int[N+1];
		A[0] = 0;
		D[0] = 0;
		int max = 0;
		for(int i=1; i<=N; i++) {
			A[i] = sc.nextInt();
			D[i] = 1;
			for(int j=1; j<=i; j++) {
				if(D[i]<=D[i-j] && A[i]>A[i-j])
					D[i] = D[i-j] + 1;
			}
			max = Math.max(max, D[i]);
		}
		System.out.print(max);
	}
}
