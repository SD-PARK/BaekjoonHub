import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		for (int N = scan.nextInt(); N > 0; N--)
			cnt += check(scan.nextInt());
		System.out.print(cnt);
	}
	static int check(int s) {
		for(int i=(int) Math.sqrt(s); i>1; i--)
			if (s%i==0)
				return 0;
		return (s<2)?0:1;
	}
}