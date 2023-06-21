function solution(s) {
    var answer = '';
    
    const ss = s.split(' ').map(str => {
        const firstChar = str.substr(0, 1);
        const remainChar = str.substr(1);
        return firstChar.toUpperCase() + remainChar.toLowerCase();
    });
    
    return ss.join(' ');
}