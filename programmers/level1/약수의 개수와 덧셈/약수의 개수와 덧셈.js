function solution(left, right) {
    var answer = 0;
    let arr = [];
    let cnt = 1;
    /* left와 right 사이의 모든 수 배열에 push */
    for (let i = 0; i <= right - left; i++) {
        arr.push(left + i);
    }
    /* 약수 개수 세서 짝수면 더하고 홀수면 빼기 */
    return arr.reduce((acc, cur) => {
        for (let i = 1; i < cur; i++) {
            if (cur % i == 0)
                cnt++;
        }
        cnt % 2 == 0 ? acc += cur : acc -= cur;
        cnt = 1;
        return acc;
    }, 0)
}