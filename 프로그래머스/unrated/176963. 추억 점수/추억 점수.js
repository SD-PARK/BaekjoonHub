function solution(names, yearning, photos) {
    let answer = [];
    
    for(let photo of photos) {
        const sum = photo.reduce((accumulator, human) => {
            const nameIndex = names.findIndex(name => name === human);
            return (yearning[nameIndex] ? yearning[nameIndex] : 0) + accumulator;
        }, 0);
        
        answer.push(sum);
    }
    
    return answer;
}