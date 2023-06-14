/* 풀이 1번 : 다 맞는데 한 문제가 계속 시간초과 */
function solution(n, k) {
    let cnt = 0;
    n = n.toString(k).split('0');
    return n.reduce((acc, e) => {
        for (let i = 3; i < e; i++) {
            if (e % i == 0) {
                cnt++;
                i = e;
            }
        }
        cnt == 0 && e != '' && e != 1 ? acc++ : cnt = 0;
        return acc;
    }, 0)
}

/* 풀이 2번 : 범위를 제곱근으로 수정 : 시간초과 해결 */
function solution(n, k) {
    let cnt = 0;
    n = n.toString(k).split('0');
    return n.reduce((acc, e) => {
        for (let i = 3; i <= Math.sqrt(e); i++) {
            if (e % i == 0) {
                cnt++;
                i = e;
            }
        }
        cnt == 0 && e != '' && e != 1 ? acc++ : cnt = 0;
        return acc;
    }, 0)
}