import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), y = scan.nextInt(), w = scan.nextInt(), h = scan.nextInt(), min = (x > y) ? y : x;
		System.out.print((w - x > h - y) ? (min > h - y) ? h - y : min : (min > w - x ? w - x : min));
	}
}