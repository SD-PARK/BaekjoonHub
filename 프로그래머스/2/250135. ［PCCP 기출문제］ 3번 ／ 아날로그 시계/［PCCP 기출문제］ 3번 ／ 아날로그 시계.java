class Solution {
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_HALF_DAY = 43200;
    private static final int HOURLY_MINUTE_OVERLAPS = 59; // 시간당 분침과 초침이 겹치는 횟수
    private static final int HALF_DAY_HOUR_OVERLAPS = 719; // 반나절당 시침과 초침이 겹치는 횟수

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int startTimeToSec = toSec(h1, m1, s1);
        int endTimeToSec = toSec(h2, m2, s2);

        int startOverlap = calculatorOverlap(startTimeToSec);
        int endOverlap = calculatorOverlap(endTimeToSec);

        int answer = endOverlap - startOverlap;

        // 시작 시간이 분침 또는 시침과 겹쳤으면 알람 추가
        if (isExactOverlap(startTimeToSec)) answer++;
        // 시작 시간과 종료 시간 사이에 정오가 지났으면 알람 한번 패스
        if (startTimeToSec < SECONDS_IN_HALF_DAY && endTimeToSec >= SECONDS_IN_HALF_DAY) answer--;

        return answer;
    }

    // 현재 시간을 초 단위로 변환
    private int toSec(int h, int m, int s) {
        return (h * 3600) + (m * 60) + s;
    }

    // 0시 0분부터 주어진 시간(초)까지 초침이 분침 또는 시침과 겹친 횟수 계산
    private int calculatorOverlap(int seconds) {
        return (seconds * HOURLY_MINUTE_OVERLAPS / SECONDS_IN_HOUR) +
                (seconds * HALF_DAY_HOUR_OVERLAPS / SECONDS_IN_HALF_DAY);
    }

    // 주어진 시간(초)에 초침이 분침 또는 시침과 겹쳤는 지 여부 확인
    private boolean isExactOverlap(int seconds) {
        return (seconds * HOURLY_MINUTE_OVERLAPS % SECONDS_IN_HOUR == 0) ||
                (seconds * HALF_DAY_HOUR_OVERLAPS % SECONDS_IN_HALF_DAY == 0);
    }
}