import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i = s.nextInt()-1, sum = 0;
		String t = s.next();
		for (; i >= 0; i--)
			sum += Integer.parseInt(t.charAt(i)+"");
		System.out.print(sum);
	}
}