import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] waitCount = new int[N+2];
        float[] failureRate = new float[N+1];
        
        Arrays.fill(waitCount, 0);
        for (int stage: stages) {
            waitCount[stage]++;
        }
        
        int clearCount = waitCount[N+1];
        Arrays.fill(failureRate, 0f);
        for (int i=N; i>0; i--) {
            clearCount += waitCount[i];
            failureRate[i] = (float) waitCount[i] / (float) clearCount;
            if (waitCount[i] < 1) failureRate[i] = 0;
            System.out.println("i: " + failureRate[i]);
        }
        
        return IntStream.rangeClosed(1, N)
            .boxed()
            .sorted((a, b) -> {
                    if (failureRate[a] == failureRate[b]) return Integer.compare(a, b);
                    else return Float.compare(failureRate[b], failureRate[a]);
                })
            .mapToInt(i -> i)
            .toArray();
    }
}