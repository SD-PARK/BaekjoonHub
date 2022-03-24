import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
		boolean[][] chs = new boolean[h][w];
		boolean C;
		int cnt = 64, count;
		
		for (int i=0; i<h; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j=0; j<w; j++)
				chs[i][j] = s[j]=='W'?true:false;
		}
		
		for (int eh=0; eh<h-7; eh++) {
			for (int ew=0; ew<w-7; ew++) {
				count = 0;
				C = chs[eh][ew];
				for (int hh=eh; hh<eh+8; hh++) {
					for (int ww=ew; ww<ew+8; ww++) {
						if (C==chs[hh][ww])
							count++;
						C = !C;	
					}
					C = !C;
				}
				cnt = Math.min(cnt, Math.min(count, 64-count));
			}
		}
		
		System.out.print(cnt);
		br.close();
	}
}