import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[s.nextInt()];
		for(int i=arr.length; i>0; i--)
			arr[i-1] = s.nextInt();
		Arrays.sort(arr);
		for (int i:arr)
			System.out.println(i);
	}
}