import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] n = new int[10];
		int cnt = 0;
		for(int i=0; i<10; i++)
		{
			n[i] = scan.nextInt() % 42;
			for(int j=0; j<i; j++)
			{
				if(n[i] == n[j])
				{
					cnt--;
					break;
				}
			}
			cnt++;
		}
		System.out.print(cnt);
	}
}