import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] n = new int[9];
		int j = 0;
		for (int i = 0; i < 9; i++)
		{
			n[i] = scan.nextInt();
			j = (n[i]>n[j])?i:j;
		}
		System.out.print(n[j] + "\n" + (j+1));
	}
}