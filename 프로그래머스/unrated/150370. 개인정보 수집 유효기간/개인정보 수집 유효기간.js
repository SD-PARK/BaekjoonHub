function solution(today, terms, privacies) {
    var answer = [];
    
    let [todayYear, todayMonth, todayDay] = today.split(/\./);
    todayMonth = +todayMonth + (+todayYear - 2000) * 12;
    todayDay = +todayDay + (todayMonth * 28);
    
    const termsMap = new Map();
    for(let term of terms) {
        let [char, expire] = term.split(/\s/);
        expire = +expire * 28;
        termsMap.set(char, expire);
    }
    
    privacies.forEach((privacy, index) => {
        let [privacyYear, privacyMonth, privacyDay, term] = privacy.split(/\.|\s/);
        privacyMonth = +privacyMonth + (+privacyYear - 2000) * 12;
        privacyDay = +privacyDay + (privacyMonth * 28);
        const expire = privacyDay + termsMap.get(term);
        
        if (expire <= todayDay) {
            answer.push(index + 1);
        }
    })
    
    return answer;
}