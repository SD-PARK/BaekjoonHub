import java.util.*;

class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		System.out.print(fac(N));
	}
	static int fac(int N) {
		return (N<1)?1:N*fac(N-1);
	}
}