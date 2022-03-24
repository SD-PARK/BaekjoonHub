import java.util.*;

public class Main {
	public static void main(String[] args) {
		int i = new Scanner(System.in).nextInt();
		int cnt = 0, j = i;
		do {
			i = (i%10)*10 + ((i/10)+(i%10))%10;
			cnt++;
		} while (i != j);
		System.out.print(cnt);
	}
}