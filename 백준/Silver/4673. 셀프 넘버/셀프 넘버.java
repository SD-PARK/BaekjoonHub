import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] n = new int[10000];
		for (int i = 0; i < 10000; i++)
		{
			if(selfNum.sn(i)<10000)
				n[selfNum.sn(i)]++;
			if (n[i] == 0)
				bw.write(i + "\n");
		}
		bw.close();
	}
}

class selfNum {
	static int sn(int num) {
		int sum = num;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}