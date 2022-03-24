import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int t, max = 0;
		char c = 0;
		int[] l = new int[26];
		while ((t = System.in.read()) != '\n') {
			if (t > 90)	t -= 32;
			l[t - 65]++;
			if (max < l[t - 65]) max = l[t - 65];
		}
		for (int i = 0; i < 26; i++) {
			if (l[i] == max)
				c = (c != 0) ? '?' : (char) (i+65);
		}
		System.out.print(c);
	}
}