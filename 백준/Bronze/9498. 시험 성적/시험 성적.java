import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int S = scan.nextInt();
		System.out.print(S>=90?'A':S>=80?'B':S>=70?'C':S>=60?'D':'F');
	}
}