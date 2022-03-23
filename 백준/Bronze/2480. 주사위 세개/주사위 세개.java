import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D1 = sc.nextInt(), D2 = sc.nextInt(), D3 = sc.nextInt();
		if(D1==D2 && D2 == D3)
			System.out.print(D1*1000 + 10000);
		else if(D1==D2 || D1==D3)
			System.out.print(D1*100 + 1000);
		else if(D2==D3)
			System.out.print(D2*100 + 1000);
		else
			System.out.print(Math.max(Math.max(D1, D2), D3) * 100);
	}
}