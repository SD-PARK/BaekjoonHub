import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = scan.nextInt(); i > 0; i--) {
			int R = scan.nextInt();
			String S = scan.next();
			for (char c:S.toCharArray())
				System.out.print((c+"").repeat(R));
			System.out.println();
		}
	}
}