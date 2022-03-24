import java.util.*;

public class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt(), rm = 0;
		for (int i = 1;; i += 6*rm) {
			if (N-i<=0)
				break;
			rm++;
		}
		System.out.print(rm+1);
	}
}