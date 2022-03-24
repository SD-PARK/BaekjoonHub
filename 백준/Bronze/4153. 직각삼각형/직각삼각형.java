import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x, y, z;
		while ((x = scan.nextInt()) + (y = scan.nextInt()) + (z = scan.nextInt()) > 0)
			if (x * x + z * z == y * y)
				System.out.println("right");
			else if (x * x + y * y == z * z)
				System.out.println("right");
			else if (z * z + y * y == x * x)
				System.out.println("right");
			else
				System.out.println("wrong");
	}
}