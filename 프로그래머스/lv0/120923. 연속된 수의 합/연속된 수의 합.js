function solution(num, total) {
    var answer = [];
    let startNum = Math.ceil(total / num) - Math.floor(num / 2);
    for (let i=0; i<num; i++) {
        answer.push(startNum + i);
    }
    return answer;
}