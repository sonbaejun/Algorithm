function solution(A, B) {
    /* 최솟값은 가장 큰 수 * 가장 작은 수 순서로 쭉 가야되므로 A는 오름차순, B는 내림차순으로 정렬 */
    A.sort((a, b) => {
        return a - b;
    })
    B.sort((a, b) => {
        return b - a;
    })
    /* 이후 정렬순서대로 a * b 누적합 계산 */
    return A.reduce((acc, cur, index) => {
        acc += cur * B[index];
        return acc;
    }, 0)
}