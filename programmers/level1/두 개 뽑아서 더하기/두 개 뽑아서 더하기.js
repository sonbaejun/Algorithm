function solution(numbers) {
    var answer = [];
    /* 전체 배열 순회하며 다 더하기 */
    numbers.map((e, index) => {
        for (let i = 1; i < numbers.length - index; i++) {
            let reduce = e + numbers[index + i];
            /* 이미 정답배열에 포함된 숫자면 말고 없으면 추가 */
            if (answer.indexOf(reduce) == -1) {
                answer.push(reduce);
            }
        }
    })
    /* 오름차순 정렬 */
    return answer.sort((a, b) => {
        return a - b;
    });
}