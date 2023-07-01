function solution(d, budget) {
    var answer = 0;
    /* d 배열을 오름차순으로 정렬 후 가장 싼 값부터 물품지원 해주기 */
    d.sort((a, b) => a - b).map(e => budget >= e ? (budget -= e, answer++) : answer)
    return answer;
}