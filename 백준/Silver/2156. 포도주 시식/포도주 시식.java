import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] G = new int[n+1];
		for(int i=1; i<=n; i++)
			G[i] = Integer.parseInt(br.readLine());
		int[][] D = new int[n+1][2];
		int max = G[1];
		D[1][0] = G[1];
		for(int i=2; i<=n; i++) {
			if(i>2)
				D[i][0] = Math.max(D[i-2][0], Math.max(D[i-2][1], D[i-3][1])) + G[i];
			else
				D[i][0] = Math.max(D[i-2][0], D[i-2][1]) + G[i];
			D[i][1] = D[i-1][0] + G[i];
			max = Math.max(max, Math.max(D[i][0], D[i][1]));
		}
		System.out.print(max);
	}
}