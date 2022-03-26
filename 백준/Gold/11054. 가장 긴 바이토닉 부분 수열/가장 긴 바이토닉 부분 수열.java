import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		int[] D = new int[N+1];
		int[] D2 = new int[N+1];
		int max = 0;
		String[] a = br.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(a[i-1]);
			D[i] = 1;
			for(int j=1; j<=i; j++)
				if(D[j] >= D[i] && A[i] > A[j])
					D[i] = D[j]+1;
		}
		for(int i=N; i>=1; i--) {
			D2[i] = 1;
			for(int j=N; j>=i; j--)
				if(D2[j] >= D2[i] && A[i] > A[j])
					D2[i] = D2[j]+1;
		}
		for(int i=1; i<=N; i++)
			max = Math.max(max, D[i] + D2[i] - 1);
		System.out.print(max);
	}
}