import java.util.*;

class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt(), r=0;
		for (int i=0; i<N; i++) {
			int M = i, j=i;
			do {
				M += j%10;
			} while ((j/=10)>0);
			if (M==N) {
				r = i;
				break;
			}
		}
		System.out.print(r);
	}
}