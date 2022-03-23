import java.util.*;

public class Main {
	public static void main(String[] args) {
		int Y = new Scanner(System.in).nextInt();
		System.out.print(Y%400==0?1:Y%100==0?0:Y%4==0?1:0);
	}
}