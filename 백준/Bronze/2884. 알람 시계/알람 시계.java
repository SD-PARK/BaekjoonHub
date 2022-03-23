import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int H = s.nextInt(), M = s.nextInt();
		M = (M-45) + H*60;
		M += M<0 ? 1440 : 0;
		System.out.printf("%d %d", M/60, M%60);
	}
}