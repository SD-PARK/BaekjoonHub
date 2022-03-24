import java.util.*;

public class Main {
	public static void main(String[] args) {
		int s = 0;
		for (char c : new Scanner(System.in).next().toCharArray()) {
			c -= (c > 82) ? (c > 89) ? 2 : 1 : 0;
			s += (c - 56) / 3;
		}
		System.out.println(s);
	}
}