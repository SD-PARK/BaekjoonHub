import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] P = new int[N+1][3];
		int[][] D = new int[N+1][3];
		for(int i=1; i<=N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<3; j++)
				P[i][j] = Integer.parseInt(str[j]);
		}
		int min = 1000*1000+1;
		for(int f=0; f<3; f++) {
			for(int c=0; c<3; c++)
				if(f==c)
					D[1][c] = P[1][c];
				else
					D[1][c] = 1000*1000+1;
			
			for(int i=2; i<=N; i++) {
				D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + P[i][0];
				D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + P[i][1];
				D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + P[i][2];
			}
			
			for(int c=0; c<3; c++)
				if(f!=c)
					min = Math.min(min, D[N][c]);
		}
		System.out.print(min);
	}
}