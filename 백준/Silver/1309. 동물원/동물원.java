import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] D = new int[N+1][3];
		D[1][0] = 1;
		D[1][1] = 1;
		D[1][2] = 1;
		for(int i=2; i<=N; i++) {
			D[i][0] = (D[i-1][0] + D[i-1][1] + D[i-1][2]) %  9901;
			D[i][1] = (D[i-1][0] + D[i-1][2]) % 9901;
			D[i][2] = (D[i-1][0] + D[i-1][1]) % 9901;
		}
		System.out.print((D[N][0] + D[N][1] + D[N][2]) % 9901);
	}
}