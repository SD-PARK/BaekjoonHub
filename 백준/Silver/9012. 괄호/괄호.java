import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int vps = 0;
			for (char i:br.readLine().toCharArray()) {
				vps += (i=='(') ? 1 : -1;
				if (vps<0) break;
			}
			sb.append(vps!=0?"NO\n":"YES\n");
		}
		
		System.out.print(sb);
	}
}