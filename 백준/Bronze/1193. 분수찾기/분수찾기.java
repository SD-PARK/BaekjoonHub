import java.util.*;

public class Main {
	public static void main(String[] args) {
		int X = new Scanner(System.in).nextInt(), i, j;
		for (i = 1; X > 0; i++)
			X -= i;
		j = (i - 1 + X);
		if (i % 2 == 0)
			System.out.print((i - j) + "/" + j);
		else
			System.out.print(j + "/" + (i - j));
	}
}