import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt(),B = s.nextInt();
		
		while(A != 0 || B != 0) {
			System.out.println(A+B);
			A = s.nextInt();
			B = s.nextInt();
		}
	}
}