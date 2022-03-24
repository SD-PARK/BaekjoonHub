import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String[] as = new String[N];
		for(int i=0; i<N; i++)
			as[i] = br.readLine();
		
		Arrays.sort(as, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length())
					return o1.compareTo(o2);
				else
					return o1.length() - o2.length();
			}
		});
		
		sb.append(as[0] + "\n");
		for (int i=1; i<N; i++)
			if(!as[i-1].equals(as[i]))
				sb.append(as[i] + "\n");
		
		System.out.print(sb);
	}
}