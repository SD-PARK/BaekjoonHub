import java.util.*;

public class Main {
	public static void main(String[] args) {
		int min = 1000000, max = -1000000;
		Scanner scan = new Scanner(System.in);
		for(int i=0, cnt=scan.nextInt(); i<cnt; i++)
		{
			int num = scan.nextInt();
			min = (min>num)?num:min;
			max = (max<num)?num:max;
		}
		System.out.printf("%d %d", min, max);
	}
}