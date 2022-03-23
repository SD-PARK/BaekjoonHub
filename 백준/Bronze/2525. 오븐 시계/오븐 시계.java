import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(), M = sc.nextInt();
		M = (M + (H*60) + sc.nextInt()) % 1440;
		System.out.print(M/60 + " " + M%60);
	}
}