import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), A, B;
		while(T-->0) {
			A = sc.nextInt();
			B = sc.nextInt();
			System.out.println((A*B)/gcd(A,B));
		}
	}
	public static int gcd(int n1, int n2) {
		if(n2==0) return n1;
		return gcd(n2, n1%n2);
	}
}