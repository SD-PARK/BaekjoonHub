import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int T = Integer.parseInt(br.readLine()); T>0; T--) {
			int N = Integer.parseInt(br.readLine());
			int[][] S = new int[N+1][3];
			for(int r=1; r<3; r++) {
				String[] str = br.readLine().split(" ");
				for(int i=1; i<=N; i++)
					S[i][r] =  Integer.parseInt(str[i-1]);
			}
			int[][] D = new int[N+1][3];
			D[1][1] = S[1][1];
			D[1][2] = S[1][2];
			for(int i=2; i<=N; i++) {
				D[i][0] = Math.max(D[i-1][1], D[i-1][2]);
				D[i][1] = Math.max(D[i-1][0], D[i-1][2]) + S[i][1];
				D[i][2] = Math.max(D[i-1][0], D[i-1][1]) + S[i][2];
			}
			bw.write(Math.max(Math.max(D[N][0], D[N][1]), D[N][2]) + "\n");
		}
		bw.close();
	}
}