import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int T = scan.nextInt(); T > 0; T--) {
			int n = scan.nextInt() / 2, i;
			for (i = 0; i < n; i++)
				if (ch(n - i) && ch(n + i))
					break;
			System.out.println((n - i) + " " + (n + i));
		}
	}

	static boolean ch(int n) {
		for (int i = (int) Math.sqrt(n); i > 1; i--)
			if (n % i == 0)
				return false;
		return true;
	}
}