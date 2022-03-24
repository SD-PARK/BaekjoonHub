import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[9];
		boolean[] sort = new boolean[100];
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sort[arr[i]] = true;
			sum += arr[i];
		}
		Loop1:
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				if(j!=i && ((arr[i] + arr[j]) == (sum - 100))) {
					sort[arr[i]] = false;
					sort[arr[j]] = false;
					break Loop1;
				}

		for(int i=0; i<100; i++)
			if(sort[i])
				sb.append(i + "\n");
		
		System.out.print(sb);
	}
}