import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt(), BC = scan.nextInt();
		BC = scan.nextInt() - BC;
		System.out.print((BC>0)?A/BC+1:-1);
	}
}