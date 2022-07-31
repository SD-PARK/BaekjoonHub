import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] interval = new long[N-1];

		int pp_loc = Integer.parseInt(br.readLine()), p_loc = pp_loc;
		for(int i=0; i<N-1; i++) {
			int loc = Integer.parseInt(br.readLine());
			interval[i] = loc - p_loc;
			p_loc = loc;
		}
		
		long gcd = interval[0];
		for(int i=1; i<N-1; i++)
			gcd = gcd(gcd, interval[i]);
		
		System.out.print((p_loc - pp_loc) / gcd - (N-1));
	}
	
	static long gcd(long p, long q) {
		if (q == 0) return p;
		return gcd(q, p%q);
	}
}