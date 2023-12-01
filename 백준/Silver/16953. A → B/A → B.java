import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int cnt = 1;

        while (a != b) {
            if (a > b) {
                System.out.println(-1);
                return;
            }
            String str = String.valueOf(b);

            if (str.charAt(str.length()-1) == '1') {
                b /= 10;
            } else if (b%2 == 0) {
                b /= 2;
            } else {
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}