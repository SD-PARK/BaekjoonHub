import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int[] d = new int[X+1];
		d[1] = 0;
		for(int i=2; i<=X; i++) {
			d[i] = d[i-1] + 1;
			if(i%2==0 && d[i] > d[i/2]+1)
				d[i] = d[i/2] + 1;
			if(i%3==0 && d[i] > d[i/3]+1)
				d[i] = d[i/3] + 1;
		}
		System.out.print(d[X]);
	}
}