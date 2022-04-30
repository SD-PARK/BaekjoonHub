import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0, cnt = 0;
		for(int i=0; i<4; i++) {
			cnt -= sc.nextInt();
			cnt += sc.nextInt();
			max = (cnt>max)?cnt:max;
		}
		System.out.print(max);
	}
}