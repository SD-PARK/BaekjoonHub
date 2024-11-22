class Solution {
    boolean solution(String s) {
        int openCnt = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                openCnt++;
            } else if (openCnt < 1) {
                return false;
            } else {
                openCnt--;
            }
        }
        return (openCnt > 0) ? false : true;
    }
}