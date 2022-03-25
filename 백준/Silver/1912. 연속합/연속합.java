import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n+1];
		int[] D = new int[n+1];
		String[] str = br.readLine().split(" ");
		int max = -1000;
		for(int i=1; i<=n; i++) {
			A[i] = Integer.parseInt(str[i-1]);
			D[i] = Math.max(D[i-1] + A[i], A[i]);
			max = (D[i]>max)?D[i]:max;
		}
		System.out.print(max);
	}
}