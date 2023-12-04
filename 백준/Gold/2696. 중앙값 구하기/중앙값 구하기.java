import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int M = Integer.parseInt(br.readLine());
            int midValueLen = (M/2)+1;
            int[] nums = new int[M];
            int[] midValue = new int[midValueLen];

            // 수열 입력
            StringTokenizer st = null;
            for (int j=0; j<M; j++) {
                // 1줄 당 10개의 수 입력
                if (j%10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                // 배열에 수 입력 및 정렬
                int input = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    nums[j] = input;
                } else {
                    for (int k=j-1; k>=0; k--) {
                        if (nums[k] > input) {
                            nums[k+1] = nums[k];
                            nums[k] = input;
                        } else {
                            nums[k+1] = input;
                            break;
                        }
                    }
                }

                // 중앙값 저장
                if (j%2 == 0) {
                    int mid = j/2;
                    midValue[mid] = nums[mid];
                }
            }

            // 출력
            bw.write(midValueLen + "");
            for (int j=0; j<midValueLen; j++) {
                if (j%10 == 0) {
                    bw.write("\n");
                }
                bw.write(midValue[j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}