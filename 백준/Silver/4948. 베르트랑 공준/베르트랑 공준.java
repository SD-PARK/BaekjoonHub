import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n, sum, j;
		while ((n = scan.nextInt()) > 0) {
			sum = 0;
			for (int i = n * 2; i > n; i--) {
				for (j = 2; j <= (int) Math.sqrt(i); j++)
					if (i % j == 0)
						break;
				sum += (j > (int) Math.sqrt(i)) ? 1 : 0;
			}
			System.out.println(sum);
		}
	}
}