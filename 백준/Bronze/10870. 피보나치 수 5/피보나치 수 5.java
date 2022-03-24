import java.util.*;

class Main {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		System.out.print(fib(n));
	}

	static int fib(int n) {
		return (n < 2) ? n : fib(n - 1) + fib(n - 2);
	}
}