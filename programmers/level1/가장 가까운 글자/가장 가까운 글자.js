function solution(s) {
    var answer = [];
    let sArr = s.split('');
    let curArr = [];
    sArr.map((e, i) => {
        let index = curArr.lastIndexOf(e);
        curArr.push(e);
        index == -1 ? answer.push(-1) : answer.push(i - index);
    }, sArr[0])
    return answer;
}