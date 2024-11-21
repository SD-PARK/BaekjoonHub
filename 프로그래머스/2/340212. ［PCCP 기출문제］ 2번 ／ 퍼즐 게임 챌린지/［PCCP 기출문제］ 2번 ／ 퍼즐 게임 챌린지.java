import java.util.Arrays;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1, end = Arrays.stream(diffs).max().getAsInt();
        int level = (start + end) / 2;
        int stageCount = diffs.length;

        while(start < level) {
            long requiredTime = 0;
            for(int stage=0; stage<stageCount; stage++) {
                requiredTime += times[stage];
                if (diffs[stage] > level) {
                    requiredTime += (long) (times[stage - 1] + times[stage]) * (diffs[stage] - level);
                }
            }

            if (requiredTime == limit) {
                return level;
            } else if (requiredTime < limit) {
                end = level;
                level = (start + level) / 2;
            } else {
                start = level;
                level = (end + level) / 2;
            }
        }

        if (end == 2) return level;
        else return level+1;
    }
}