import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int T = s.nextInt();
		for (int i=1; i<=T; i++) {
			int C = s.nextInt() + (s.nextInt()*10);
			sb.append("Case #" + i + ": " + (C%10) + " + " + (C/10) + " = " + (C%10 + C/10) + "\n");
		}
		System.out.print(sb);
	}
}