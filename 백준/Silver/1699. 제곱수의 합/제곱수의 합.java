import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N+1];
		D[1] = 1;
		for(int i=2; i<=N; i++) {
			D[i] = -1;
			for(int j=1; j*j<=i; j++)
				if(D[i] == -1 || D[i] > D[i-(j*j)]+1)
					D[i] = D[i-(j*j)]+1;
		}
		System.out.print(D[N]);
	}
}