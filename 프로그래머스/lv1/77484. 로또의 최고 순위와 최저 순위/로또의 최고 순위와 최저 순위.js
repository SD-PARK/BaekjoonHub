function solution(lottos, win_nums) {
    var answer = [];
    let zeroNum = 0;
    
    for(let i=0; i<6; i++) {
        let index = win_nums.indexOf(lottos[i]); // 일치하는 번호 제거
        if (index != -1) win_nums.splice(index, 1);
        zeroNum += lottos[i] == 0 ? 1 : 0; // 0의 개수 카운트
    }
    
    let len = win_nums.length;
    const low = (len>4) ? 6 : (len+1);
    const high = (len-zeroNum > 4) ? 6 : (len-zeroNum+1);
    answer = [high, low];
    
    return answer;
}