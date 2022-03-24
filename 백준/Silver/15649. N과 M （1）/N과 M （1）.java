import java.io.*;
import java.util.*;

class Main {
	public static boolean[] arr;
	public static int[] print;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N+1];
		print = new int[M];
		
		sy(N, M, 0);
		
		System.out.print(sb);
	}
	
	public static void sy(int N, int M, int depth) {
		for(int i=1; i<=N; i++) {
			if (!arr[i]) {
				arr[i] = true;
				print[depth] = i;
				if (depth+1 >= M) {
					for(int j:print)
						if(j>0)
							sb.append(j + " ");
					sb.append("\n");
				} else {
					sy(N, M, depth+1);
				}
				arr[i] = false;
				print[depth] = 0;
			}
		}
	}
}