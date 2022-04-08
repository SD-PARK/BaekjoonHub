import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[][] D = new long[65][10];
		for(int i=0; i<10; i++)
			D[1][i] = 1;
		for(int i=2; i<65; i++)
			for(int j=0; j<10; j++)
				for(int k=0; k<=j; k++)
					D[i][j] += D[i-1][k];
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			long sum = 0;
			for(long i:D[n])
				sum+=i;
			System.out.println(sum);
		}
	}
}