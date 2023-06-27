function solution(number, limit, power) {
    let divisorCnt = []; // 기사의 약수 개수를 담은 배열
    /* 1번부터 number까지 기사의 번호 지정 */
    let soldierNum = Array(number).fill().map((e, index) => {
        return index + 1;
    })
    // 약수 개수 구하기, 범위를 제곱근까지로 해서 실행시간 단축
    soldierNum.map(e => {
        if (e <= 2) {
            divisorCnt.push(e);
        } else {
            let cnt = 0;
            let checkSqrt = false;
            for (let i = 2; i <= Math.sqrt(e); i++) {
                if (e % i == 0) {
                    if (i * i == e) checkSqrt = true;
                    cnt++;
                }
            }
            checkSqrt ? divisorCnt.push(cnt * 2 + 1) : divisorCnt.push(cnt * 2 + 2) // 제곱 수가 있으면 하나 줄여주기(같은 숫자가 두번 들어가니까)
        }
    })
    /* 누적 합 계산 => limit초과하면 power를, 아니면 현재값 누적 */
    return answer = divisorCnt.reduce((acc, cur) => {
        return cur > limit ? acc + power : acc + cur
    }, 0)
}