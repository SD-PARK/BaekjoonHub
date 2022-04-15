import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int[] D = new int[n+1];
		D[1] = n;
		for(int i=2; i<=n; i++) {
			D[i] = n;
			if(i>4)
				D[i] = Math.min(D[i], D[i-5]+1);
			D[i] = Math.min(D[i], D[i-2]+1);
		}
		System.out.print(D[n]>=n?-1:D[n]);
	}
}