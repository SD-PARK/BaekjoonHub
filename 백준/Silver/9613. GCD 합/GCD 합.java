import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = Integer.parseInt(br.readLine()); t>0; t--) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] num = new int[n];
			long sum = 0;
			
			for(int i=0; i<n; i++)
				num[i] = Integer.parseInt(st.nextToken());
			for(int i=0; i<n-1; i++)
				for(int j=i+1; j<n; j++)
					sum += GCD(num[i], num[j]);
			
			sb.append(sum+"\n");
		}
		System.out.print(sb);
	}
	
	static int GCD(int a, int b) {
		if (b==0)
			return a;
		return GCD(b, a%b);
	}
}