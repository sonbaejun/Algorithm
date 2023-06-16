function solution(n, t, m, p) {
    var answer = '';
    let insert = '';
    /* 필요 턴 만큼의 모든 숫자(문자) 삽입 */
    for (let i = 0; i < t * m; i++)
        insert += i.toString(n);
    let arr = insert.split('');
    /* 자기 순서마다 하나씩 총 t개만큼 가져가지 */
    for (let i = p - 1; i < t * m; i += m)
        answer += arr[i];
    /* 10진수 이상일시 대문자 변환 */
    return n > 10 ? answer.toUpperCase() : answer
}