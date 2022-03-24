import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();
		int[] scr = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			scr[i] = 0;
			String str = scan.next();
			int cb = 0;
			for (char t : str.toCharArray())
				scr[i] += cb = (t == 'O') ? cb + 1 : 0;
		}
		for (int i = 0; i < cnt; i++)
			System.out.println(scr[i]);
	}
}