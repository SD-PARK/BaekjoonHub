import java.util.*;

public class Main {
	public static void main(String[] args) {
		int cnt5 = 0, cnt3 = 0, N = new Scanner(System.in).nextInt();

		cnt5 = N / 5;
		N %= 5;

		while (N != 0) {
			if (N % 3 == 0) {
				cnt3 += N / 3;
				N = 0;
			} else {
				cnt5--;
				N += 5;
				if (cnt5 < 0)
				{
					cnt5 = -1;
					break;
				}
			}
		}
		
		System.out.print(cnt5 + cnt3);
	}
}