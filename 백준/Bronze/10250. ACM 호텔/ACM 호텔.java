import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = sc.nextInt(); i > 0; i--) {
			int H = sc.nextInt(), W = sc.nextInt(), N = sc.nextInt();
			int a = (N % H) > 0 ? (N % H) * 100 + 1 : H * 100;
			a += (N / H);
			System.out.println(a);
		}
	}
}