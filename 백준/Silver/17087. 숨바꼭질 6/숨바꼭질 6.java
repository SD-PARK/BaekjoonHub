import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken())-S;
		for(int i=1; i<N; i++)
			D = GCD(D, Integer.parseInt(st.nextToken())-S);
		
		System.out.print(Math.abs(D));
	}
	
	static int GCD(int a, int b) {
		if (b==0)
			return a;
		return GCD(b, a%b);
	}
}