const answer = [];

function solution(n) {
    hanoi(n, 1, 2, 3);
    
    return answer;
}

function hanoi(n, start, mid, end) {
    if (n < 2) {
        answer.push([start, end]);
    } else {
        hanoi(n-1, start, end, mid);
        answer.push([start, end]);
        hanoi(n-1, mid, start, end);
    }
}