import java.util.*;

public class Main {
	public static void main(String[] args) {
		int i, cnt = 0;
		String[] apb = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String T = new Scanner(System.in).next();
		for (int a = 0; a < 8; a++) {
			i = T.indexOf(apb[a], 0);
			while (i != -1) {
				cnt++;
				i = T.indexOf(apb[a], i + 1);
			}
		}
		System.out.print(T.length() - cnt);
	}
}