function solution(arr) {
    var answer = [];
    /* 배열 순회하며 연속되지 않으면 정답 배열에 push */
    arr.map((e, index) => {
        if (answer.length == 0 || answer[answer.length - 1] != e) {
            answer.push(e);
        }
    })
    return answer;
}