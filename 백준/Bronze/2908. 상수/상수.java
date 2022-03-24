import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = Integer.valueOf(new StringBuffer(scan.next()).reverse().toString()),
			B = Integer.valueOf(new StringBuffer(scan.next()).reverse().toString());
		System.out.println((A > B) ? A : B);
	}
}