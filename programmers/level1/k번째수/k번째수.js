function solution(array, commands) {
    var answer = [];
    commands.map(e => {
        let arr = []
        for (let i = e[0] - 1; i < e[1]; i++) {
            arr.push(array[i]);
        }
        arr.sort((a, b) => {
            return a - b;
        })
        answer.push(arr[e[2] - 1]);
    })
    return answer;
}