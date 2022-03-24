import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int T=sc.nextInt(); T>0; T--) {
			int N = sc.nextInt();
			int[] d = new int[N+1];
			d[0] = 0;
			for(int i=1; i<=N; i++) {
				if(i<4) {
					d[i] = 1;
					for(int j=1; j<=i; j++)
						d[i] += d[i-j];
				}
				else
					d[i] = d[i-1] + d[i-2] + d[i-3];
			}
			System.out.println(d[N]);
		}
	}
}