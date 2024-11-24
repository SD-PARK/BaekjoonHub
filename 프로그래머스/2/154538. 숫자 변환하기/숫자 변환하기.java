import java.util.Arrays;

class Solution {
    // 최대 연산 횟수
    private static final int MAX_OPERATION_COUNT = 1_000_000;
    
    public int solution(int x, int y, int n) {
        int[] minOperations = new int[y+1]; // minOperations[i] = X에서 i까지의 최소 연산 횟수
        Arrays.fill(minOperations, MAX_OPERATION_COUNT);

        minOperations[x] = 0;
        for (int i=x; i<=y; i++) {
            if (i-n >= 0)
                minOperations[i] = Math.min(minOperations[i], minOperations[i-n]+1);
            if (i%2 == 0)
                minOperations[i] = Math.min(minOperations[i], minOperations[i/2]+1);
            if (i%3 == 0)
                minOperations[i] = Math.min(minOperations[i], minOperations[i/3]+1);
        }

        return (minOperations[y] >= MAX_OPERATION_COUNT) ? -1 : minOperations[y];
    }
}