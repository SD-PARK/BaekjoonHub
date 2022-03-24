import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean[] l = new boolean[1001], r = new boolean[1001];
		for (int i = 0; i < 6; i++) {
			int j = scan.nextInt();
			if (i % 2 > 0)
				r[j] = !r[j];
			else
				l[j] = !l[j];
		}
		for (int i = 1; i < 1001; i++)
			System.out.print(l[i] == true ? i + " " : "");
		for (int i = 1; i < 1001; i++)
			System.out.print(r[i] == true ? i : "");
	}
}