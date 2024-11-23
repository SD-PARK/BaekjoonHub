import java.util.Arrays;

class Solution {
    private static final int MAX_VALUE = 1_000_000;
    
    public int solution(int x, int y, int n) {
        int[] answer = new int[y+1];
        Arrays.fill(answer, MAX_VALUE);

        answer[x] = 0;
        for (int i=x; i<=y; i++) {
            if (i-n >= 0) answer[i] = Math.min(answer[i], answer[i-n]+1);
            if (i%2 == 0) answer[i] = Math.min(answer[i], answer[i/2]+1);
            if (i%3 == 0) answer[i] = Math.min(answer[i], answer[i/3]+1);
        }

        return (answer[y] >= MAX_VALUE) ? -1 : answer[y];
    }
}