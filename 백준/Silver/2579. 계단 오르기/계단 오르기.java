import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N+1];
		for(int i=1; i<=N; i++)
			S[i] = Integer.parseInt(br.readLine());
		int[][] D = new int[N+1][2];
		D[1][0] = S[1];
		D[1][1] = S[1];
		for(int i=2; i<=N; i++) {
			D[i][0] = Math.max(D[i-2][0], D[i-2][1]) + S[i];
			D[i][1] = D[i-1][0] + S[i];
		}
		System.out.print(Math.max(D[N][0], D[N][1]));
	}
}