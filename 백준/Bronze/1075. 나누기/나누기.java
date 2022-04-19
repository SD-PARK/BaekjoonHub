import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(), F=sc.nextInt();
		N -= N%100;
		int ans = 0;
		for(int i=99; i>=0; i--)
			if((N+i)%F==0)
				ans=i;
		System.out.print(String.format("%02d", ans));
	}
}