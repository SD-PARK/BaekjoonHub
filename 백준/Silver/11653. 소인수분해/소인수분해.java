import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		while(N>1)
		{
			System.out.println(check(N));
			N/=check(N);
		}
	}
	static int check(int s) {
		for(int i=2; i<=(int) Math.sqrt(s); i++)
				if(s%i==0)
					return i;
		return (s<4||s>1)?s:-1;
	}
}