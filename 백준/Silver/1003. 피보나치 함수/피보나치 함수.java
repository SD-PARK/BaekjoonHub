import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int T=sc.nextInt(); T>0; T--) {
			int N = sc.nextInt();
			int[][] d = new int[N+1][2];
			d[0][0] = 1;
			d[0][1] = 0;
			if(N>0) {
				d[1][0] = 0;
				d[1][1] = 1;
				for(int i=2; i<=N; i++) {
					d[i][0] = d[i-1][0] + d[i-2][0];
					d[i][1] = d[i-1][1] + d[i-2][1];
				}
			}
			System.out.println(d[N][0] + " " + d[N][1]);
		}
	}
}