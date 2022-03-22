import java.util.*;

public class Main {
	public static void main(String args[]) {
		int n = new Scanner(System.in).nextInt();
		int[] d = new int[n+1];
		d[0] = 1;
		d[1] = 1;
		for(int i=2; i<=n; i++) {
			d[i] = d[i-1] + d[i-2];
			d[i] %= 10007;
		}
		System.out.print(d[n]);
	}
}