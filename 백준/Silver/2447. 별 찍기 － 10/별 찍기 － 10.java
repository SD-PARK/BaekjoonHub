import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		for (int h=0; h<N; h++)
		{
			for (int w=0; w<N; w++)
			{
				bw.write(star(N, N, h, w));
			}
			bw.write("\n");
		}
		bw.close();
	}
	static char star(int N, int n, int h, int w) {
		if (n<=3) {
			if (n<=3 && (h-1)%3 == 0 && (w-1)%3==0)
				return ' ';
			else
				return '*';
		} else {
			if (((h-(n/3))%n)>=0 && ((h-(n/3))%n)<(n/3) && ((w-(n/3))%n)>=0 && ((w-(n/3))%n)<(n/3))
				return ' ';
			else
				return star(N, n/3, h, w);
		}
	}
}