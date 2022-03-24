import java.util.*;

public class Main {
	public static void main(String[] args) {
		int s = new Scanner(System.in).nextInt();
		for (int i = 1; i <= s; i++) {
			System.out.println(" ".repeat(s-i) + "*".repeat(i));
		}
	}
}