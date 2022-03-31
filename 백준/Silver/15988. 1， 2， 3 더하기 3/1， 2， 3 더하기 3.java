import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), n;
		long[] D = new long[1000001];
		D[0] = 1;
		D[1] = 1;
		D[2] = 2;
		for(int i=3; i<1000001; i++)
			D[i] = (D[i-1] + D[i-2] + D[i-3]) % 1_000_000_009;
		while(T-->0)
			System.out.println(D[sc.nextInt()]);
	}
}