import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] TD = new int[n];
		int[] RD = new int[n];
		String[] str = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			A[i] = Integer.parseInt(str[i]);
		TD[0] = A[0];
		for(int i=1; i<n; i++)
			TD[i] = Math.max(TD[i-1]+A[i], A[i]);
		RD[n-1] = A[n-1];
		for(int i=n-2; i>=0; i--)
			RD[i] = Math.max(RD[i+1]+A[i], A[i]);
		int max=TD[0];
		for(int i=1; i<n-1; i++) {
			max = Math.max(max, TD[i]);
			max = Math.max(max, TD[i-1] + RD[i+1]);
		}
		max = Math.max(max, TD[n-1]);
		System.out.print(max);
	}
}