import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		int[] D = new int[N+1];
		int max = 0;
		String[] a = br.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(a[i-1]);
			D[i] = A[i];
			for(int j=1; j<=i; j++) {
				if(D[j]+A[i] > D[i] && A[i] > A[j])
					D[i] = D[j]+A[i];
			}
			max = (D[i]>max)?D[i]:max;
		}
		System.out.print(max);
	}
}