import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] lo = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			lo[i][0] = Integer.parseInt(st.nextToken());
			lo[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(lo, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		
		for(int[] i:lo)
			sb.append(i[0] + " " + i[1] + "\n");
		
		System.out.print(sb);
	}
}