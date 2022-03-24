import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int r= scan.nextInt() * scan.nextInt() * scan.nextInt();
		int[] num = new int[10];
		for(int i=0; i<Math.log10(r); i++)
			num[(int) (r/Math.pow(10, i))%10]++;
		for(int i=0; i<10; i++)
			System.out.println(num[i]);
	}
}