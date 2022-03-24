import java.util.*;

public class Main {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = new Scanner(System.in).nextInt(); i > 0; i--)
			sum += i;
		System.out.print(sum);
	}
}