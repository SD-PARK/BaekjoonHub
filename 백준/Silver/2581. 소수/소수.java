import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0, min = 0;
		for (int M = scan.nextInt(), N = scan.nextInt(); M <= N; M++)
		{
			min = (sum==0)?check(M):min;
			sum += check(M);
		}
		System.out.print((min==0)?-1:sum + "\n" + min);
	}
	static int check(int s) {
		for(int i=(int) Math.sqrt(s); i>1; i--)
			if (s%i==0)
				return 0;
		return (s<2)?0:s;
	}
}