import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] S = new int[n];
		int[] D = new int[n]; // 상자 최대 개수
		int max = 1;
		for(int i=0; i<n; i++) {
			S[i] = sc.nextInt();
			D[i] = 1;
			for(int j=0; j<i; j++)
				if(D[j]>=D[i] && S[i]>S[j]) {
					D[i] = D[j]+1;
					max = Math.max(max, D[i]);
				}
		}
		System.out.print(max);
	}
}