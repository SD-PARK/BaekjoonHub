function solution(keymap, targets) {
    var answer = [];
    let keys = new Map();
    
    for(key of keymap) {
        key.split('').forEach((k, i) => {
            if (keys.has(k)) {
                if (keys.get(k) > (i + 1)) {
                    keys.set(k, i + 1);
                }
            } else {
                keys.set(k, i + 1);
            }
        });
    }
    
    for(target of targets) {
        const result = target.split('').reduce((sum, key) => {
            if (keys.has(key)) {
                return sum + keys.get(key);
            } else {
                return 10001;
            }
        }, 0);
        
        if (result > 10000) {
            answer.push(-1);
        } else {
            answer.push(result);
        }   
    }
    
    return answer;
}