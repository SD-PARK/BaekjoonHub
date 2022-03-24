import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double sum = 0, max = 0;
		int s = scan.nextInt();
		for (int i = 0; i < s; i++) {
			int a = scan.nextInt();
			max = (max < a) ? a : max;
			sum += a;
		}
		System.out.print((float)sum/(max*s)*(100*s)/s);
	}
}