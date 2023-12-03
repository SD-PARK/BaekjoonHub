import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] btns = new int[m];
        int result = Math.abs(n-100);

        for(int i=0; i<m; i++) {
            btns[i] = sc.nextInt();
        }

        for(int i=0; i<=1_000_000; i++) {
            int numLen = String.valueOf(i).length();
            int len = numLen + Math.abs(n-i);
            if (result > len && checkIncludeNums(i, btns)) {
                result = len;
            }
        }

        System.out.print(result);
    }

    public static boolean checkIncludeNums(int checkNum, int[] nums) {
        String numString = String.valueOf(checkNum);

        for (int num: nums) {
            String temp = String.valueOf(num);
            if (numString.contains(temp)) {
                return false;
            }
        }

        return true;
    }
}