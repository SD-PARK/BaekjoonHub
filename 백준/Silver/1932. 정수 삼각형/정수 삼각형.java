import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n+1][n+1];
		int[][] D = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			String[] st = br.readLine().split(" ");
			for(int j=1; j<=i; j++)
				tri[i][j] = Integer.parseInt(st[j-1]);
		}
		D[1][1] = tri[1][1];
		for(int i=2; i<=n; i++)
			for(int j=1; j<=i; j++) {
				D[i][j] = Math.max(D[i-1][j-1], D[i-1][j]) + tri[i][j];
			}
		int max = 0;
		for(int i:D[n])
			max = Math.max(max, i);
		System.out.print(max);
	}
}
