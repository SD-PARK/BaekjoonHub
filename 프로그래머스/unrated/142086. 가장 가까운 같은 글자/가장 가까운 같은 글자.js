function solution(s) {
    let answer = [];
    const reverseS = s.split('').reverse();
    const length = s.length;
    for(let i=0; i<length; i++) {
        const char = reverseS[0];
        reverseS.splice(0, 1);
        const index = reverseS.indexOf(char);
        answer.push(index >= 0 ? index + 1 : index);
    }
    
    return answer.reverse();
}