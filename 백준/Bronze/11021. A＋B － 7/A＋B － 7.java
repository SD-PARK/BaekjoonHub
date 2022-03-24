import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i=1; i<=T; i++)
			System.out.println("Case #" + i + ": " + (s.nextInt() + s.nextInt()));
	}
}