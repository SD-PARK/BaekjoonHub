import java.util.*;

public class Main {
	static int N;
	static char[][] cndy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cndy = new char[N][N];
		int ans = 0;
		char temp;
		for(int i=0; i<N; i++)
			cndy[i] = sc.next().toCharArray();
		for(int i=0; i<N; i++)
			for (int j=0; j<N; j++) {
				if(i+1<N) {
					temp = cndy[i][j]; cndy[i][j] = cndy[i+1][j]; cndy[i+1][j] = temp;
					ans = Math.max(ans, Math.max(check(i, j), check(i+1, j)));
					temp = cndy[i][j]; cndy[i][j] = cndy[i+1][j]; cndy[i+1][j] = temp;
				}
				if(j+1<N) {
					temp = cndy[i][j]; cndy[i][j] = cndy[i][j+1]; cndy[i][j+1] = temp;
					ans = Math.max(ans, Math.max(check(i, j), check(i, j+1)));
					temp = cndy[i][j]; cndy[i][j] = cndy[i][j+1]; cndy[i][j+1] = temp;
				}
			}
		System.out.print(ans);
	}
	
	static int check(int x, int y) {
		int max = 0, cnt = 1;
		for(int i=1; i<N; i++) {
			if(cndy[x][i-1] == cndy[x][i])
				cnt++;
			else
				cnt = 1;
			max = (cnt>max)?cnt:max;
		}
		cnt = 1;
		for(int i=1; i<N; i++) {
			if(cndy[i-1][y] == cndy[i][y])
				cnt++;
			else
				cnt = 1;
			max = (cnt>max)?cnt:max;
		}
		return max;
	}
}