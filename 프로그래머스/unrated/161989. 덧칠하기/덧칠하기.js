function solution(n, m, section) {
    var answer = 0;
    let position = 0;
    
    while(section.length > 0) {
        position = section[0] + (m - 1);
        while(position >= section[0]) {
            section.splice(0, 1);
        }
        answer++;
    }
    
    return answer;
}