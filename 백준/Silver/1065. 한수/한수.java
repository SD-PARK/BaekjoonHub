import java.util.*;

public class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt(), cnt = 0;
		for (int i = 1; i <= N; i++)
			if (hs(i))
				cnt++;
		System.out.println(cnt);
	}

	static boolean hs(int n) {
		if (n < 100)
			return true;

		if ((n % 10) - (n / 10 % 10) == (n / 10 % 10) - (n / 100))
			return true;
		else
			return false;
	}
}