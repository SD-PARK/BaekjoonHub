import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte A = scan.nextByte();
		byte B = scan.nextByte();
		if (A>0 && B<10)
			System.out.print(A + B);
	}
}