function solution(s) {
    let index = parseInt(s.length / 2);
    return s.length % 2 == 0 ? s.substr(index - 1, 2) : s.substr(index, 1) //짝수와 홀수인 경우로 나누어 처리
}